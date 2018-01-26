package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(3);
        traverse(root, 0, result);
        return result;

    }

    public void traverse( TreeNode node, int level, List<List<Integer>> result)
    {
        if (node == null) {
            return;
        }
        else {

            List<Integer> levelList = result.size() > level ? result.get(level): null;
            if(levelList == null) {
                levelList = new ArrayList<>();
                result.add(level, levelList);
            }
            traverse(node.left, level +1, result);
            traverse(node.right, level +1, result);
            if (level % 2 == 0) {
                levelList.add(node.val);
            }
            else {
                levelList.add(0, node.val);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
       System.out.println(new BinaryTreeZigZagTraversal().zigzagLevelOrder(root));
    }
}
