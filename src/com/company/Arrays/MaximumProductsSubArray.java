package com.company.Arrays;

public class MaximumProductsSubArray {

    public int maxProduct(int[] nums) {

        int result = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){

                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;

    }

    public static void main(String[] args) {

   // int numbers [] = new int[]{3, -1, 4};
    //    int numbers [] = new int[]{0, 2};
  //     int numbers [] = new int[]{-2,0,-1};
        //int numbers [] = new int[]{ -2,3,-4};
       // int numbers [] = new int[]{ -4, -3};
       // int numbers [] = new int[]{ 6,3,-10,0,2};

         int numbers [] = new int[]{ 2,-5,-2,-4,3};







        System.out.println(new MaximumProductsSubArray().maxProduct(numbers));
    }
}
