package com.practice.random;

import java.util.*;

public class Solution {

    static class Node {
        public int index;
        public int val;

        public Node(int index, int val) {
            this.val = val;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return index == node.index &&
                    val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, val);
        }
    }

    static class Graph {
        private Map<Node, List<Node>> map = new HashMap<>();

        public void addVertex(Node node) {
            map.put(node, new LinkedList<Node>());
        }

        public void addEdge(Node source,
                            Node destination,
                            boolean bidirectional) {

            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
            if (bidirectional) {
                map.get(destination).add(source);
            }
        }

        void DFSUtil(Node v, Map<Node, Boolean> visited) {
            visited.put(v, true);

            for (Node neighbour : map.get(v)) {
                if (!visited.containsKey(neighbour))
                    DFSUtil(neighbour, visited);
            }
        }

        int countNotReach(Node v) {
            Map<Node, Boolean> visited = new HashMap<>();
            DFSUtil(v, visited);
            // Return count of not visited nodes
            return map.size() - visited.size();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();
            while (test-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
                solve1(arr);
            }
        } catch (Exception e) {
            return;
        }

/*        int[] input1 = {1,3,5};
        int[] input2 = {1,10};
        solve(new int[]{3,6});
        solve(input1);
        solve(input2);
        solve(new int[]{5,6,7,1,2});
        solve(new int[]{1,2,5,6,2, 7});*/
    }

    static void solve1(int[] v){
        Integer min = Integer.MAX_VALUE, max = 1;
        int n = v.length,b=1;
        for(int i=0; i<n-1; i++){
            if (v[i+1]-v[i]<3)
                b++;
            if ((v[i+1]-v[i]>2)||(i+2==n))
            {
                if(b>max) max=b;
                if(b<min) min=b;
                b=1;
            }
            if ((v[i+1]-v[i]>2)&&(i+2==n)) min=1;

        }
        System.out.println(min + " " + max);
    }

    private static void solve(int[] input) {
        Graph graph = new Graph();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (Math.abs(input[i] - input[j]) <= 2)
                    graph.addEdge(new Node(i, input[i]), new Node(j, input[j]), true);
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Node vertex : graph.map.keySet()) {
            int notReach = graph.countNotReach(vertex);
            int infected = graph.map.size() - notReach;
            if (infected > max)
                max = infected;
            if (infected < min)
                min = infected;
        }

        if(min == Integer.MAX_VALUE)
            min = 1;
        if(max == Integer.MIN_VALUE)
            max = 1;
        System.out.println(min + " " + max);

    }
}
