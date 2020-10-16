package com.sweeftdigital.task2;

public class Main {
    public static void main(String[] args) {
        System.out.println(minSplit(1003));
    }

    public static int minSplit(int amount){
        int numberOfCoins = 0;
        int reminder = 0;
        numberOfCoins += amount / 50;
        reminder = amount % 50;
        numberOfCoins += reminder / 20;
        reminder = reminder % 20;
        numberOfCoins += reminder / 10;
        reminder = reminder % 10;
        numberOfCoins += reminder / 5;
        reminder = reminder % 5;
        numberOfCoins += reminder;
        return numberOfCoins;
    }
}
