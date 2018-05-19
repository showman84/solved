package com.company.Tree;

import java.util.*;

public class SymmetricalTree {


    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return right == left;
        }
        if (left.val != right.val) {
            return false;
        }
        else {

            return isSymmetric(left.left, right.right) && (isSymmetric(left.right, right.left));
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);


        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

       System.out.println(new SymmetricalTree().isSymmetric(root));
    }
}
