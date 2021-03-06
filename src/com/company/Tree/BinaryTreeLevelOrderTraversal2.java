package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(3);
        traverse(result, root, 0);
        return result;

    }

    public void traverse( List<List<Integer>> ans, TreeNode root, int level)
    {
        if(root==null) return;

        if(ans.size()==level)
            ans.add(0,new ArrayList<Integer>());

        ans.get(ans.size()-level-1).add(root.val);

        traverse(ans,root.left,level+1);
        traverse(ans,root.right,level+1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeLevelOrderTraversal2().levelOrderBottom(root));
    }
}
