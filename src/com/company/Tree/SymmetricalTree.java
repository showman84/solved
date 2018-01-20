package com.company.Tree;

import java.util.*;

public class SymmetricalTree {


    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        boolean result = true;
        TreeNode node = root;

        queue.add(node);
        while (!queue.isEmpty()) {
            node =  queue.remove();
            if (node == null) {
                break;
            }
            System.out.println(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return result;
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
