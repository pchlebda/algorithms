package com.pc.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        List<List<Integer>> lists = generatePermutation(array);

        System.out.println(lists);
    }

    private static List<List<Integer>> generatePermutation(int[] array) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), array);
        return list;
    }

    private static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtracking(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
