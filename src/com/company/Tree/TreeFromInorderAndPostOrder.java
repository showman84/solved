package com.company.Tree;

import java.util.HashMap;

public class TreeFromInorderAndPostOrder {

    private HashMap map = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node =  buildTree(preorder, inorder, 0, inorder.length - 1);
        return  node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd) {

        if (preStart > preEnd || preStart >= inorder.length) {
            return null;
        }


        int in_start = (int)map.getOrDefault(preorder[preEnd], -1);

        int end = -1;
        for (int i = 0; i <= preEnd; i++) {
            int val = (int)map.getOrDefault(preorder[i], -1);
            if ( val !=  -1 &&  val < in_start ) {
                end++;
            }
        }

        int endRight = -1;
        for (int i = end + 1; i < preEnd; i++) {
            int val = (int)map.getOrDefault(preorder[i], -1);
            if ( val !=  -1 &&  val > in_start ) {
                endRight = i;
            }
        }


        if(preStart == preEnd) {
            return new TreeNode(inorder[in_start]);
        }


        TreeNode node = new TreeNode(inorder[in_start]);
        node.left = buildTree(preorder, inorder,     preStart, end);
        node.right = buildTree(preorder, inorder, end + 1, endRight);

        return node;
    }



    public static void main(String[] args) {
        int postorder [] = new int[]{9,15,7,20,3};
        int inorder [] = new int[]{9,3,15,20,7};
        System.out.println(new TreeFromInorderAndPostOrder().buildTree(inorder, postorder));
    }
}
