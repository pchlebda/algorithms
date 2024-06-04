package com.pc.kmp;

public class Main {

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";

        kmp(pat, txt);
    }

    private static void kmp(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        int[] lps = new int[m];
        computeLps(pat, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                ++i;
                ++j;
            }
            if (j == m) {
                System.out.println("Found at position " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    ++i;
                }
            }
        }
    }

    private static void computeLps(String pat, int[] lps) {
        lps[0] = 0;
        int len = 0;
        int i = 1;
        int m = lps.length;
        while (i < m) {

            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    ++i;
                }
            }
        }
    }
}
