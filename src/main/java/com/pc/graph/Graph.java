package com.pc.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.addNeighbour(node2);
        node1.addNeighbour(node5);
        node1.addNeighbour(node6);

        node2.addNeighbour(node3);

        node6.addNeighbour(node7);
        node6.addNeighbour(node8);

        node3.addNeighbour(node4);

        dfs(node1);
    }


    static class Node {

        int val;
        List<Node> neighbours;
        boolean visited;

        public Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
            visited = false;
        }

        public void addNeighbour(Node node) {
            neighbours.add(node);
            node.neighbours.add(node);
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isVisited() {
            return visited;
        }
    }


    private static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!node.isVisited()) {
                System.out.print(node.val + " ");
                queue.addAll(node.neighbours);
                node.setVisited(true);
            }
        }
    }

    private static void dfs(Node start) {

        Stack<Node> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (!node.isVisited()) {
                System.out.print(node.val + " ");
                stack.addAll(node.neighbours);
                node.setVisited(true);
            }
        }
    }
}
