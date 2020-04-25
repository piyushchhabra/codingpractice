package com.practice.ds.tree;

import com.practice.ds.util.Utils;

public class NodesAtDistanceK {

    public static void main(String[] args) {
        BTNode root = Utils.getSampleBst();
        BTNode target = new BTNode(2);
        Utils.printBinaryTreeInorder(root);
        printKDistantNodes(root,2,target);
    }

    public static int printKDistantNodes(BTNode node, int k, BTNode target) {
        if(node==null) return -1;
        if(node.val == target.val) {
            printKDistantDown(node, k);
            return 0;
        }

        int d1 = printKDistantNodes(node.left, k, target);
        if(d1 != -1) {
            if(1+d1==k) {
                System.out.print(node.val+ " ");
            }else {
                printKDistantDown(node.right, k-d1-2);
            }
            return 1+d1;
        }

        int d2 = printKDistantNodes(node.right, k, target);
        if(d2 != -1) {
            if(1+d2==k) {
                System.out.print(node.val+" ");
            }else {
                printKDistantDown(node.left, k-d2-2);
            }
            return 1+d2;
        }

        return -1;
    }

    private static void printKDistantDown(BTNode node, int k) {
        if(k<0 || node==null)
            return;
        if(k==0)
            System.out.print(node.val+" ");
        else{
            printKDistantDown(node.left, k-1);
            printKDistantDown(node.right, k-1);
        }

    }
}
