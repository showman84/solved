package com.company;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

public class MaximumSumInBST {


    /*

                1
             2     3
           4  1   2  3


                4

             5          6

      7         2       3     8

     */
    public int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode node) {

        maxPathSumInternal(node);
        return maxValue;

    }
    public int maxPathSumInternal(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathSumInternal(node.left));
        int right = Math.max(0, maxPathSumInternal(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(8);

        MaximumSumInBST m = new MaximumSumInBST();

        System.out.println(m.maxPathSum(root));
    }
}
