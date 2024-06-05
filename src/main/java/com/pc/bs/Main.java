package com.pc.bs;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = randomArray(300);
        Arrays.sort(array);
        int key = 10_001;

        System.out.println("Searched " + key);
        System.out.println("BinarySearch  " + binarySearch(array, key));
        System.out.println("Arrays.binarySearch " + Arrays.binarySearch(array, key));
    }

    private static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1, mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            }
            if (array[mid] == key) {
                return mid;
            }
        }

        return -(left + 1);
    }


    private static int[] randomArray(int elements) {
        int[] array = new int[elements];
        Random random = new Random();

        for (int i = 0; i < elements; ++i) {
            array[i] = random.nextInt(10_000);
        }

        return array;
    }

}
