package com.pc.numDistinct;

public class NumDistinct {

    public static void main(String[] args) {
        String a = "ABCDE";
        String b = "ACE";

        int i = numDistinct(a, b);

        System.out.println(i);
    }

    public static int numDistinct(String a, String b) {
        int[][] mem = new int[b.length() + 1][a.length() + 1];

        for (int j = 0; j <= a.length(); j++) {
            mem[0][j] = 1;
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (b.charAt(i) == a.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[b.length()][a.length()];
    }

}
