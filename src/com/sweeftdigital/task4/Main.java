package com.sweeftdigital.task4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        if (isProperly(")(()())")) {
            System.out.println("the order is balanced");
        } else {
            System.out.println("the order is not balanced");
        }
    }

    public static boolean isProperly(String sequence){
        boolean isProper = false;
        char[] tuples = sequence.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < tuples.length; i++) {
            if (tuples[i] == '(') {
                stack.push(tuples[i]);
            } else {
                if (stack.empty()) {
                    isProper =  false;
                    break;
                } else {
                    stack.pop();
                    isProper = true;
                }
            }
        }

        return isProper;
    }
}
