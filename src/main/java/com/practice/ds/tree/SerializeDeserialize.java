package com.practice.ds.tree;

import com.practice.ds.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserialize {

    public String serialized = "";

    public static void main(String[] args) {

        /*BTNode root = Utils.getSampleBst();
        Utils.printBinaryTreePreorder(root);

        SerializeDeserialize obj = new SerializeDeserialize();
        obj.serialize(root);
        System.out.println("Serialized string="+obj.serialized);
        BTNode node = obj.deserialize(obj.serialized);
        Utils.printBinaryTreePreorder(node);*/

        BTNode root = Utils.getSampleBst();
        Utils.printBinaryTreePreorder(root);
        String serialized = levelOrderSerialize(root);
        System.out.println(serialized);
        Utils.printBinaryTreePreorder(levelOrderDeserialize(serialized));

    }



    private static String levelOrderSerialize(BTNode root) {
        List<String> list = new ArrayList<>();
        LinkedList<BTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BTNode curr = queue.poll();
            if (curr == null) {
                list.add("#");
            } else {
                list.add(curr.val + "");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return String.join(",", list);
    }

    private static BTNode levelOrderDeserialize(String str) {
        BTNode root = null;
        String[] arr = str.split(",");
        String curr = arr[0];
        if (curr.equalsIgnoreCase("#"))
            return root;

        root = new BTNode(Integer.parseInt(curr));
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            BTNode node = queue.poll();
            if(node != null) {
                BTNode left = null;
                BTNode right = null;
                curr = arr[i];
                if(!curr.equalsIgnoreCase("#")) {
                    left = new BTNode(Integer.parseInt(curr));
                }
                node.left = left;
                queue.add(left);
                i++;
                curr = arr[i];
                if(!curr.equalsIgnoreCase("#")) {
                    right = new BTNode(Integer.parseInt(curr));
                }
                node.right = right;
                queue.add(right);
                i++;
            }
        }
        return root;
    }

    public void serialize(BTNode node) {
        if (node == null) {
            serialized += "# ";
            return;
        }
        serialized += node.val + " ";
        serialize(node.left);
        serialize(node.right);
    }

    public BTNode deserialize(String data) {
        if (data == null)
            return null;

        String[] arr = data.split(" ");

        return helper2(arr, new Count());
        /*System.out.println();
         int[] t = {0};
        return helper(arr, t);*/
    }

    public BTNode helper2(String[] arr, Count count) {
        if (arr[count.count].equals("#")) {
            return null;
        }

        BTNode root = new BTNode(Integer.parseInt(arr[count.count]));

        count.count += 1;
        root.left = helper2(arr, count);
        count.count += 1;
        root.right = helper2(arr, count);

        return root;
    }

    public BTNode helper(String[] arr, int[] t) {
        System.out.print(t[0] + " ");
        if (arr[t[0]].equals("#")) {
            return null;
        }

        BTNode root = new BTNode(Integer.parseInt(arr[t[0]]));

        t[0] = t[0] + 1;
        root.left = helper(arr, t);
        t[0] = t[0] + 1;
        root.right = helper(arr, t);

        return root;
    }

    public BTNode helper1(String[] arr, Integer t) {
        System.out.print(t + " ");
        if (arr[t].equals("#")) {
            return null;
        }

        BTNode root = new BTNode(Integer.parseInt(arr[t]));

        t = t + 1;
        root.left = helper1(arr, t);
        t = t + 1;
        root.right = helper1(arr, t);

        return root;
    }

    static class Count {
        int count = 0;
    }
}
