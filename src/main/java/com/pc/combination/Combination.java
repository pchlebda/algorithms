package com.pc.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Combination {

    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(A);
        backtrack(list, new ArrayList<>(), A, B, 0);
        return new ArrayList<>(new HashSet<>(list));
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> list, List<Integer> tempList, ArrayList<Integer> nums, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.size(); i++) {
                tempList.add(nums.get(i));
                backtrack(list, tempList, nums, remain - nums.get(i), i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
