package com.pc.grid;

import java.util.ArrayList;

public class UniquePaths {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(new ArrayList<>());

        ArrayList<Integer> r1 = new ArrayList<>();
        r1.add(0);
        r1.add(0);
        r1.add(0);

        ArrayList<Integer> r2 = new ArrayList<>();
        r2.add(0);
        r2.add(1);
        r2.add(0);

        ArrayList<Integer> r3 = new ArrayList<>();
        r3.add(0);
        r3.add(0);
        r3.add(0);

        list.add(r1);
        list.add(r2);
        list.add(r3);

        int i = uniquePathsWithObstacles(list);
        System.out.println(i);

    }

    public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int[][] mem = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); ++i) {
            for (int j = 0; j < A.get(0).size(); ++j) {
                mem[i][j] = -1;
            }
        }

        return calculateUniquePaths(0, 0, mem, A);
    }

    public static int calculateUniquePaths(int x, int y, int[][] mem, ArrayList<ArrayList<Integer>> A) {
        if (x == A.size() - 1 && y == A.get(0).size()) {
            return 1;
        }

        if (x >= A.size() || y >= A.get(0).size() || A.get(x).get(y) == 1) {
            return 0;
        }
        if (mem[x][y] != -1) {
            return mem[x][y];
        }

        mem[x][y] = calculateUniquePaths(x + 1, y, mem, A) + calculateUniquePaths(x, y + 1, mem, A);
        return mem[x][y];
    }
}
