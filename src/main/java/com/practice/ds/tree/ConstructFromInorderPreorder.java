package com.practice.ds.tree;

import com.practice.ds.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructFromInorderPreorder {

    public static void main(String[] args) {

        BTNode root  = new BTNode(3);
        root.left = new BTNode(9);
        root.right = new BTNode(20);
        root.right.right  = new BTNode(7);
        root.right.left = new BTNode(15);
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        Utils.printBinaryTreeInorder(root);

        BTNode newRoot = construct(preorder, inorder);
        Utils.printBinaryTreeInorder(newRoot);
    }

    private static BTNode construct(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<in.length; i++)
            map.put(in[i], i);
        AtomicInteger rootIndex = new AtomicInteger(0);
        return helper(rootIndex, map, pre, 0, in.length-1);
    }

    private static BTNode helper(AtomicInteger rootIndex, Map<Integer, Integer> inorder, int[] pre, int start, int end) {
        if(start > end)
            return null;
        BTNode node = new BTNode(pre[rootIndex.getAndIncrement()]);
        if(start == end)
            return node;
        int index = inorder.get(node.val);
        node.left = helper(rootIndex, inorder, pre, start, index -1);
        node.right = helper(rootIndex, inorder, pre, index+1, end);
        return node;
    }
}
