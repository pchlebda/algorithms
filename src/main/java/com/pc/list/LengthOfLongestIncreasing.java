package com.pc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is solution for implementing LIS
 */
public class LengthOfLongestIncreasing {

    public static void main(String[] args) {

        int[] array = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        int i = lenOfLongestDynamic(array);

        System.out.println(i);
    }


    static int lenOfLongestDynamic(int[] array) {

        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; ++i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    static int lengthOfLongest(int[] array) {

        if (array.length < 1) {
            return 0;
        }

        List<Integer> result = new ArrayList<>();
        result.add(array[0]);

        for (int i = 0; i < array.length; ++i) {

            if (array[i] > result.get(result.size() - 1)) {
                result.add(array[i]);
            } else {
                int index = Collections.binarySearch(result, array[i]);

                if (index < 0) {
                    index = -(index + 1);
                }
                result.set(index, array[i]);
            }
        }

        return result.size();
    }

}
