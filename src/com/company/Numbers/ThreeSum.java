package com.company.Numbers;

import com.company.Arrays.RotateArray;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            fillTwoSum(nums, i, result);
        }
        return result;
    }

    private void fillTwoSum(int [] nums, int targetIndex,  List<List<Integer>> result) {
        Hashtable<Integer, Integer> map = new Hashtable();
        int target = -1 * nums[targetIndex];
        for (int i = 0; i < nums.length;) {
            if (i == targetIndex) {
                i++;
                continue;
            }
            if (map.containsKey((target - nums[i]))) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[map.get((target - nums[i]))]);
                temp.add(nums[targetIndex]);
                if(!tripletExits(result, temp)) {
                    result.add(temp);
                }
            }
            map.put(nums[i], i);
            i++;
        }
    }

    public boolean tripletExits(List<List<Integer>> result, List<Integer> entry) {

        for (List<Integer> local: result) {
            int count = 0;
            for(int i: local) {
                if(entry.contains(i)) {
                   count++;
                }
                if (count == 3) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numbers [] = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(numbers));
    }
}
