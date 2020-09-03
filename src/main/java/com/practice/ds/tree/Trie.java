package com.practice.ds.tree;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    @Getter
    Node root;
    public Trie() {
        root = new Node('#', false, false);
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.hasNeighbour(c)) {
                boolean isWordEnd = i == word.length() - 1;
                curr.addNext(c, isWordEnd, isWordEnd);
            }
            curr = curr.getNeighbour(c);
        }
    }

    public boolean hasWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!curr.hasNeighbour(c))
                return false;
            curr = curr.getNeighbour(c);
        }
        return true;
    }

    public void printAll() {
        getAllWords(root, new StringBuilder(""), new ArrayList<>()).forEach(word -> System.out.print(word + " "));
        System.out.println();
    }

    public List<String> getAllWords(Node node, StringBuilder sb, List<String> res) {
        if(!node.equals(root))
            sb.append(node.c);
        if(!node.isLeaf) {
            for(Node neighbour : node.neighbours.values()) {
                StringBuilder copy = new StringBuilder(sb.toString());
                getAllWords(neighbour, copy, res);
            }
        }
        else {
           res.add(sb.toString());
        }
        return res;
    }


    public static class Node {
        @Getter
        char c;
        boolean wordEnd;
        boolean isLeaf;
        @Getter
        Map<Character, Node> neighbours;

        public Node(char c, boolean wordEnd, boolean isLeaf) {
            this.c = c;
            this.wordEnd = wordEnd;
            this.isLeaf = isLeaf;
            neighbours = new HashMap<>();
        }

        public void addNext(char c, boolean wordEnd, boolean isLeaf) {
            if (this.isLeaf)
                this.isLeaf = false;
            neighbours.put(c, new Node(c, wordEnd, isLeaf));
        }

        public boolean hasNeighbour(char c) {
            return neighbours.containsKey(c);
        }

        public Node getNeighbour(char c) {
            return neighbours.get(c);
        }
    }
}
