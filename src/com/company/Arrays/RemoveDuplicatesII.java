package com.company.Arrays;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {

        if (nums == null) return 0;
        if (nums.length < 2)
            return nums.length;

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i -1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int numbers [] = new int[]{1, 1, 2, 3, 3, 4, 5, 6};

        System.out.println(new RemoveDuplicatesII().removeDuplicates(numbers));
    }
}
