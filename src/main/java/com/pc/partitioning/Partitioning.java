package com.pc.partitioning;

public class Partitioning {

    public static void main(String[] args) {
        System.out.println(minCut("aba"));
        System.out.println(minCut("aab"));

    }

    public static int minCut(String A) {
        char[] array = A.toCharArray();
        int n = array.length;
        int[] cut = new int[n];
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (array[j] == array[i] && (j + 1 > i - 1 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

}
