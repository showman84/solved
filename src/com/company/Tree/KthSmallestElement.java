package com.company.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int count = 0;
        while (node != null ||!stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(++count == k) return node.val;
            node = node.right;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
       System.out.println(new KthSmallestElement().kthSmallest(root, 2));
    }
}
