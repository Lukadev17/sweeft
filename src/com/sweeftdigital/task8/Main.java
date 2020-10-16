package com.sweeftdigital.task8;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.print("From: ");
        String from = scanner.nextLine();
        System.out.print("To: ");
        String to = scanner.nextLine();
        System.out.println(df.format(exchangeRate(from, to)));
    }

    public static double exchangeRate(String from, String to) {
        double rate = 0;

        try {
            String url = "http://www.nbg.ge/rss.php?fbclid=IwAR3Q7mNzuyXzd7Jdh2F3h8ul6QBUERLlJyRgzYmrw84hD4yMaASUi_2Dbtk";

            URLConnection nbg = new URL(url).openConnection();
            nbg.addRequestProperty("Accept", "application/xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(nbg.getInputStream());

            String[] descriptionContent = document.getElementsByTagName("description").item(1).getTextContent()
                    .replace("<table border=\"0\">", "")
                    .replace("</table>", "")
                    .replace("<tr>", "")
                    .replace("</tr>", "")
                    .trim()
                    .split("</td>");

            List<String> descriptionContentList = new ArrayList<>();
            int skipFourthIndex = 3;
            int skipFifthIndex = 4;

            for (int i = 0; i < descriptionContent.length; i++) {
                if (i == skipFourthIndex) {
                    skipFourthIndex += 5;
                    continue;
                }
                if (i == skipFifthIndex) {
                    skipFifthIndex += 5;
                    continue;
                }
                descriptionContentList.add(descriptionContent[i].replace("<td>", "").trim());
            }

            Map<String, Currency> currencies = new HashMap<>();
            int skipThirdIndex = 2;

            List<String> tempCurrencyList = new ArrayList<>();
            Currency currency;

            for (int i = 0; i < descriptionContentList.size(); i++) {
                tempCurrencyList.add(descriptionContentList.get(i));
                if (i == skipThirdIndex) {
                    skipThirdIndex += 3;
                    currency = new Currency(tempCurrencyList.get(0),
                            tempCurrencyList.get(1),
                            Double.parseDouble(tempCurrencyList.get(2)));
                    currencies.put(currency.getCode(), currency);
                    tempCurrencyList.clear();
                }
            }

            if (from.equals("GEL") && to.equals("GEL")) {
                rate = 1.0000;
            } else if (from.equals("GEL")) {
                rate = 1 / currencies.get(to).getRate();
            } else if (to.equals("GEL")) {
                rate = currencies.get(from).getRate();
            } else {
                rate = currencies.get(from).getRate() / currencies.get(to).getRate();
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        return rate;
    }
}