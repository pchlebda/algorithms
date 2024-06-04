package com.pc.klargest;

import java.util.PriorityQueue;

public class KLargest {

    public static void main(String[] args) {
        int a[]
                = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int k = 3;
        System.out.print(k + " largest elements are : ");
        printKLargest(a, k);
    }

    static void printKLargest(int[] array, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int e : array) {
            heap.add(e);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }

}
