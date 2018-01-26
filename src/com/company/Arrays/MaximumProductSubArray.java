package com.company.Arrays;

import java.util.Hashtable;

public class MaximumProductSubArray {

    class Result{
        public int result;
        public int indexStart;
        public int indexEnd;
    }

    public int maxProduct(int[] nums) {

        if (nums == null) return 0;

        Result localMaximum = new Result();
        Result globalMaximum = new Result();

        localMaximum.result = nums[0];
        localMaximum.indexStart = localMaximum.indexEnd = 0;

        globalMaximum.result = localMaximum.result;
        globalMaximum.indexStart = globalMaximum.indexEnd = 0;

        for (int i = 1; i < nums.length; i++){

            if (localMaximum.result <= 0) {
                if (nums[i] < 0){
                    localMaximum.result *= nums[i];
                    localMaximum.indexEnd = i;
                }
               else{
                     localMaximum.result = nums[i];
                     localMaximum.indexStart = localMaximum.indexEnd = i;
                }
            }
            else {
                if (nums[i] > 0){
                    localMaximum.result *= nums[i];
                    localMaximum.indexEnd = i;
                }
                else {
                    localMaximum.result = nums[i];
                    localMaximum.indexStart = localMaximum.indexEnd = i;
                }
            }

            if (globalMaximum.result < localMaximum.result){
                globalMaximum.result = localMaximum.result;
                globalMaximum.indexStart = localMaximum.indexStart;
                globalMaximum.indexEnd = localMaximum.indexEnd;
            }
        }
        return globalMaximum.result;

    }

    public static void main(String[] args) {
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();

//        System.out.println(maximumProductSubArray.maxProduct(new int[]{2,3,-2,4}) + " should be: " + 6);
  //      System.out.println(maximumProductSubArray.maxProduct(new int[]{-4, -3}) + " should be: " + 12);

    //    System.out.println(maximumProductSubArray.maxProduct(new int[]{0, 2}) + " should be: " + 2);
        System.out.println(maximumProductSubArray.maxProduct(new int[]{-2, 3, -4}) + " should be: " + 24);


    }
}
