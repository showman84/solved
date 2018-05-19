package com.company.Arrays;

import com.company.Numbers.DivideNumbers;

import java.util.Hashtable;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int numbers [] = new int[]{1, 2, 3, 4};
        System.out.println(new ProductOfArray().productExceptSelf(numbers));
    }
}
