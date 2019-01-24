package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>(3);
        traverse(result, root, 0);
        return result;

    }

    public void traverse( List<Integer> ans, TreeNode root, int level)
    {
        if(root==null) return;

        if (ans.size() <= level) {
            ans.add(level, root.val);
        } else {
            ans.set(level, root.val);
        }



        traverse(ans,root.left,level+1);
        traverse(ans,root.right,level+1);
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
    }
}
