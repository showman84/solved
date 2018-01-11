package com.company.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode previous = null;
        while (node != null ||!stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (previous != null && node.val <= previous.val) {
                return false;
            }
            previous = node;
            node = node.right;

        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidateBST().isValidBST(root));
    }
}
