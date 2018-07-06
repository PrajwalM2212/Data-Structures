package Graphs.Graph_Implementation;

import java.util.Scanner;

import static java.lang.System.out;


public class Graph {

    private LinkedList[] adjList;

    public Graph(int num_vertices) {

        adjList = new LinkedList[num_vertices];
        for (int i = 0; i < num_vertices; i++) {
            adjList[i] = new LinkedList(i);
        }

    }

    public static class LinkedList {

        public static class Node {
            Node next;
            int data;

            Node(int data) {
                this.data = data;
            }
        }

        private Node head;

        public LinkedList(int u) {
            this.head = new Node(u);
        }

    }

    private void read(int num_paths, Graph graph, Scanner scanner) {

        while (num_paths > 0) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            {
                LinkedList.Node current = graph.adjList[u].head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new LinkedList.Node(v);
            }
            num_paths--;
        }
    }

    private void print(Graph graph) {


        for (int i = 0; i < graph.adjList.length; i++) {
            out.println(String.format("Adjacency List of vertex %d", i));
            out.print("head");
            LinkedList.Node current = graph.adjList[i].head;
            while (current.next != null) {
                current = current.next;
                out.print(" --> " + current.data);
            }
            out.println("\n");

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_vertices = scanner.nextInt();
        Graph graph = new Graph(num_vertices);
        int num_paths = scanner.nextInt();
        graph.read(num_paths, graph, scanner);
        scanner.close();
        graph.print(graph);
    }

}
