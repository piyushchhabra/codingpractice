package com.practice.random;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush.chhabra on 30/07/2019
 */
public class Vinay {

    @Data
    static class Node {
        int val;
        List<Node> childList;
        public Node(int val) {
            this.val = val;
            childList = new ArrayList<>();
        }

        public void addChild(Node node) {
            this.childList.add(node);
        }
    }

    static Node getSampleTree() {
        Node root = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);


        root.childList.add(one);
        root.childList.add(two);
        one.childList.add(three);
        three.childList.add(four);
        three.childList.add(five);
        five.childList.add(six);
        six.childList.add(seven);
        return root;
    }

    static boolean isValid(Node node) {
        if(node.val==1 || node.val==3 || node.val==6)
            return false;
        return true;
    }

    static int treeCount = 1;
    static void visit(Node node, List<Integer> visited, boolean isPrevValid) {
        visited.add(node.val);
        boolean isCurrentValid = isValid(node);

        if(isPrevValid==false && isCurrentValid) {
            treeCount++;
        }

        for(Node child : node.childList) {
            if(!visited.contains(child.val)) {
                visit(child, visited, isCurrentValid);
            }
        }
    }

    public static void main(String[] args) {
        Node root = getSampleTree();
        visit(root, new ArrayList<>(), true);
        System.out.println("treeCount="+treeCount);
    }
}
