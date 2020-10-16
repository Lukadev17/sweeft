package com.sweeftdigital.task1;

public class Main {
    public static void main(String[] args) {
        if (isPalindrome("radar")) {
            System.out.println("input text is palindrome");
        } else {
            System.out.println("input text is not palindrome");
        }
    }

    public static Boolean isPalindrome(String text) {
        StringBuilder reversedText = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--)
            reversedText.append(text.charAt(i));

        return text.equals(reversedText.toString());
    }
}
