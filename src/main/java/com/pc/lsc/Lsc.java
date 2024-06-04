package com.pc.lsc;

import java.util.HashSet;
import java.util.Set;

public class Lsc {

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lenOfLongestSubstring(s));
    }


    private static int lenOfLongestSubstring(String text) {
        int max = 0;
        int i = 0, j = 0;
        Set<Character> characters = new HashSet<>();

        while (j < text.length()) {
            if (!characters.contains(text.charAt(j))) {
                characters.add(text.charAt(j));
                ++j;
                max = Math.max(max, characters.size());
            } else {
                characters.remove(text.charAt(i));
                i++;
            }
        }

        return max;
    }
}
