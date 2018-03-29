package com.company.Tree;


import java.util.LinkedList;

public class LowestCommonAnesctor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);

       // root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(8);

        root.left.right = new TreeNode(-2);
        root.left.left = new TreeNode(4);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root ;
        TreeNode q = root.left;

        System.out.println(new LowestCommonAnesctor().lowestCommonAncestor(root, p, q).val);
    }

}
