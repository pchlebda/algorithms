package com.pc.word;

import java.util.ArrayList;
import java.util.List;


public class WordBreaking {

    public static void main(String[] args) {
        System.out.println(wordBreak("myinterviewtrainer", new ArrayList<>(List.of("trainer", "my", "interview"))));
        System.out.println(wordBreak("a", new ArrayList<>(List.of("aaa"))));

    }

    public static int wordBreak(String A, ArrayList<String> B) {

        int[] dp = new int[A.length() + 1];

        for (int i = 0; i < dp.length; ++i) {
            dp[i] = -1;
        }

        return find(A, 0, dp, B);
    }

    public static int find(String s, int index, int[] dp, ArrayList<String> list) {

        if (s.length() == index) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        boolean found = false;

        for (String word : list) {
            if (s.startsWith(word, index) && find(s, index + word.length(), dp, list) == 1) {
                found = true;
                break;
            }
        }

        dp[index] = found ? 1 : 0;
        return dp[index];
    }

}
