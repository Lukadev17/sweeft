package com.sweeftdigital.task5;

public class Main {
    public static void main(String[] args) {
        System.out.println(countVariants(4));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int countVariants(int stairsCount) {
        return fibonacci(stairsCount + 1);
    }
}
