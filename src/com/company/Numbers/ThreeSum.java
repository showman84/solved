package com.company.Numbers;

import com.company.Arrays.RotateArray;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            fillTwoSum(nums, i, result);
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
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
            List temp = new ArrayList(entry);
            for(int i: local) {
                if(temp.remove(new Integer(i))) {
                   count++;
                }
                if (count == 3) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numbers [] = new int[]{-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
        System.out.println(new ThreeSum().threeSum(numbers));
    }
}
