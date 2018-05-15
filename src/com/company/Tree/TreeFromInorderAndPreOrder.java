package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeFromInorderAndPreOrder {

    private HashMap map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
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


        int in_start = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]) {
                in_start = i;
            }
        }

        int end = preStart;
        for (int i = preStart + 1; i <= preEnd; i++) {
            int val = (int)map.getOrDefault(preorder[i], -1);
            if ( val !=  -1 &&  val < in_start ) {
                end++;
            }
        }

        int endRight = end;
        for (int i = end + 1; i <= preEnd; i++) {
            int val = (int)map.getOrDefault(preorder[i], -1);
            if ( val !=  -1 &&  val > in_start ) {
                endRight++;
            }
        }


        if(preStart == preEnd) {
            return new TreeNode(inorder[in_start]);
        }


        TreeNode node = new TreeNode(inorder[in_start]);
        node.left = buildTree(preorder, inorder,     preStart  + 1, end);
        node.right = buildTree(preorder, inorder, end + 1, endRight);

        return node;
    }



    public static void main(String[] args) {
        int preorder [] = new int[]{7,10,4,3,1,2,8,11};
        int inorder [] = new int[]{4,10,3,1,7,11,8,2};
        System.out.println(new TreeFromInorderAndPreOrder().buildTree(preorder, inorder));
    }
}
