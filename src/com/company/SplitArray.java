package com.company;

public class SplitArray {

    public boolean isPossible(int[] nums) {

        boolean result = false;

        int counter = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - nums[ i - 1] == 1) {
                counter++;
            }
            else {
                
            }


        }
        return result;

    }

    public static void main(String[] args) {

        int coins [] = new int[]{1,2,3,3,4,5};

        System.out.println(new SplitArray().isPossible(coins));
    }
}
