package com.company.Tree;

import com.company.Arrays.RotateArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List result = new ArrayList();
        TreeNode node = root;
        while (node != null ||!stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
             node = node.right;
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
       System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(root));
    }
}
