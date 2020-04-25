package com.practice.ds.util;

import com.practice.ds.tree.BTNode;

public class Utils {

    public static BTNode getSampleBst() {
        BTNode root = new BTNode(6);
        root.left = new BTNode(2);
        root.right = new BTNode(10);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(3);
        root.left.left.left = new BTNode(0);
        return root;
    }

    public static void printBinaryTreePreorder(BTNode root) {
        printBinaryTreePreorderHelper(root);
        System.out.println();
    }

    private static void printBinaryTreePreorderHelper(BTNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printBinaryTreePreorderHelper(node.left);
            printBinaryTreePreorderHelper(node.right);
        }
    }

    public static void printBinaryTreeInorder(BTNode root) {
        printBinaryTreeInorderHelper(root);
        System.out.println();
    }

    private static void printBinaryTreeInorderHelper(BTNode node) {
        if (node != null) {
            printBinaryTreeInorderHelper(node.left);
            System.out.print(node.val + " ");
            printBinaryTreeInorderHelper(node.right);

        }
    }
}
