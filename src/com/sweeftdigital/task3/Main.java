package com.sweeftdigital.task3;

public class Main {
    public static void main(String[] args) {
        System.out.println(notContains( new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,20}));
    }

    public  static int notContains(int[] array) {
        int minNumberNotContained = 0;
        int temp = 0;
        int key = 1;

        if (array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (binarySearch(array, key)) {
                key++;
            } else {
                minNumberNotContained = key;
                break;
            }
        }

        if (minNumberNotContained == 0) {
            minNumberNotContained = array[array.length - 1] + 1;
        }

        return minNumberNotContained;
    }

    private static boolean binarySearch(int[] arr, int key) {
        int first = 0;
        int last = arr.length - 1;
        boolean contains = false;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                contains = true;
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return false;
        }

        return contains;
    }
}
