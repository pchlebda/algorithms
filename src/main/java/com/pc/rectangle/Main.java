package com.pc.rectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        if (A == null || A.isEmpty() || A.get(0) == null) {
            return 0;
        }

        int m = A.size();
        int n = A.get(0).size();

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];

        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (int i = 0; i < m; ++i) {
            int left = 0;
            int right = n;

            updateHeightsAndLeftBoundaries(A.get(i), heights, leftBoundaries, left);
            updateRightBoundaries(A.get(i), rightBoundaries, right);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);

        }

        return maxRectangle;
    }

    private void updateHeightsAndLeftBoundaries(ArrayList<Integer> row, int[] heights, int[] leftBoundaries,
            int left) {
        for (int j = 0; j < heights.length; j++) {
            if (row.get(j) == 1) {
                heights[j]++;
                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
            } else {
                heights[j] = 0;
                leftBoundaries[j] = 0;
                left = j + 1;
            }
        }
    }

    private void updateRightBoundaries(ArrayList<Integer> row, int[] rightBoundaries, int right) {
        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
            if (row.get(j) == 1) {
                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
            } else {
                rightBoundaries[j] = right;
                right = j;
            }
        }
    }

    private int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
        for (int j = 0; j < heights.length; j++) {
            int width = rightBoundaries[j] - leftBoundaries[j];
            int area = heights[j] * width;
            maxRectangle = Math.max(maxRectangle, area);
        }
        return maxRectangle;
    }

}
