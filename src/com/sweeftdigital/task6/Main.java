package com.sweeftdigital.task6;

public class Main {
    public static void main(String[] args) {
        DesignStructure designStructure = new DesignStructure();
        designStructure.add(10);
        designStructure.add(20);
        designStructure.add(30);
        designStructure.add(40);
        System.out.println(designStructure.arr);
        designStructure.remove(20);
        System.out.println(designStructure.arr);
    }
}

