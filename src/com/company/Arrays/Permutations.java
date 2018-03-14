package com.company.Arrays;

import java.util.Hashtable;

public class Permutations {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }
        Hashtable map = new Hashtable();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;

    }

    public static void main(String[] args) {
        int numbers [] = new int[]{1, 1, 2, 3,3, 4, 5, 6};
        System.out.println(new Permutations().containsDuplicate(numbers));
    }
}
