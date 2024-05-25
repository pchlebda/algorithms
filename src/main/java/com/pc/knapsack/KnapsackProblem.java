package com.pc.knapsack;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] profit = {10, 15, 40};
        int knapsack = knapsack(6, weights, profit);
        System.out.println(knapsack);

    }

    static int knapsack(int capacity, int[] weights, int[] values) {

        int[][] array = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; ++i) {
            for (int j = 0; j <= capacity; ++j) {
                if (j == 0 || i == 0) {
                    array[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    array[i][j] = Math.max(values[i - 1] + array[i - 1][j - weights[i - 1]], array[i - 1][j]);
                } else {
                    array[i][j] = array[i - 1][j];
                }
            }
        }

        return array[weights.length][capacity];
    }

}
