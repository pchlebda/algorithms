package com.pc.bs;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = {9, 3, 4, 2, 5};

        quickSort(array, 0, array.length - 1);
        System.out.println(isSorted(array));

    }

    private static boolean isSorted(int[] array) {
        int prev = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < prev) {
                return false;
            }
            prev = array[i];
        }

        return true;
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


    private static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int pivot = pivot(array, l, r);
            quickSort(array, pivot + 1, r);
            quickSort(array, l, pivot - 1);
        }
    }

    private static int pivot(int[] array, int l, int r) {
        int pivot = array[r];
        int i = l - 1;
        for (int j = l; j <= r; ++j) {
            if (array[j] < pivot) {
                ++i;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
