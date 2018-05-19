package com.company.Tree;

import java.util.*;

public class MinimumDepthInTree {

    private int minDepth = 0;

    public int minDepth(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(3);
        traverse(root, 0, result);
        return minDepth;

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
            if (node.left == null && node.right == null) {
                minDepth = minDepth == 0 ? level + 1 : Math.min(minDepth, level + 1);
                return;
            }
            else {
                traverse(node.left, level + 1, result);
                traverse(node.right, level + 1, result);
            }

            if(levelList == null) {
                levelList = new ArrayList<>();
                result.add(level, levelList);
            }
            levelList.add(node.val);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
       System.out.println(new MinimumDepthInTree().minDepth(root));
    }
}
