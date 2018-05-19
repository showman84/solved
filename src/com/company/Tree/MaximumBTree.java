package com.company.Tree;

import java.util.Arrays;


public class MaximumBTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMaximumBinaryTreeInternal(nums, 0, nums.length);
    }

        public TreeNode constructMaximumBinaryTreeInternal(int[] nums, int l, int r) {

        if (l == r) {
            return null;
        }
         int max = findMax(nums, l, r);
         TreeNode root = new TreeNode(nums[max]);
         root.left = constructMaximumBinaryTreeInternal(nums, l, max);
         root.right = constructMaximumBinaryTreeInternal(nums, max + 1, r);
         return root;
        }

    public int findMax(int[] nums, int l, int r) {

        int index = l;

        for (int i = l; i < r; i++) {

            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;

    }


    public static void main(String[] args) {

        int array[] = new int[]{3,2,1,6,0,5};
        System.out.println(new MaximumBTree().constructMaximumBinaryTree(array).val);
    }

}
