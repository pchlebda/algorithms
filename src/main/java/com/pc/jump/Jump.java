package com.pc.jump;

import java.util.ArrayList;
import java.util.List;

public class Jump {

    public static void main(String[] args) {

        System.out.println(jump(new ArrayList<>(List.of(2, 1, 1))));
        System.out.println(jump(new ArrayList<>(List.of(2, 3, 1, 1, 4))));

    }

    public static int jump(ArrayList<Integer> A) {
        int n = A.size();

        if (n <= 1) {
            return 0;
        }
        if(A.get(0) == 0){
            return -1;
        }

        int begin = 0, end = 0;
        int maxReach = -1;
        int steps = 0;

        while (begin < n) {
            maxReach = Math.max(maxReach, begin + A.get(begin));
            if (maxReach >= n - 1) {
                return ++steps;
            }
            if (begin == end) {
                end = maxReach;
                ++steps;
            }

            ++begin;
        }

        return -1;
    }
}
