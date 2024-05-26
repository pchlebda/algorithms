package com.pc.gas;

import java.util.Arrays;
import java.util.List;

public class GasStation {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163,
                953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738,
                7, 209);
        List<Integer> B = Arrays.asList(862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797,
                512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517,
                237, 884);
        int i = canCompleteCircuit(A, B);

        System.out.println(i);

    }

    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        int fuel = 0;
        for (int i = 0; i < A.size(); ++i) {
            fuel += (A.get(i) - B.get(i));
        }
        if (fuel < 0) {
            return -1;
        }

        int startIndex = 0;
        fuel = 0;

        for (int i = 0; i < A.size(); ++i) {
            fuel += (A.get(i) - B.get(i));
            if (fuel < 0) {
                startIndex = i + 1;
                fuel = 0;
            }
        }

        return startIndex;
    }

    public static boolean canRound(final List<Integer> A, final List<Integer> B, int startIndex) {

        int fuel = 0;
        for (int i = 0; i <= A.size(); ++i) {
            int index = (i + startIndex) % A.size();
            fuel += A.get(index);
            fuel -= B.get(index);
            if (fuel < 0) {
                return false;
            }
        }
        return true;
    }

}
