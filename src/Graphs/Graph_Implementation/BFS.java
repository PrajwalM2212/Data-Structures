package Graphs.Graph_Implementation;

import java.util.LinkedList;


public class BFS {

    private int numVertex;
    private LinkedList<Integer>[] adjList;

    public BFS(int numVertex) {

        this.numVertex = numVertex;
        adjList = new LinkedList[numVertex];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }

    }


    private void addEdge(int u, int v) {
        adjList[u].add(v);
    }


    private void traversal(int source) {

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numVertex];
        queue.add(source);
        visited[source] = true;


        while (queue.size() != 0) {

            int vertex = queue.poll();
            LinkedList<Integer> adjVertex = adjList[vertex];
            System.out.print(vertex + " ");


            for (int i = 0; i < adjVertex.size(); i++) {

                if (!visited[adjVertex.get(i)]) {
                    visited[adjVertex.get(i)] = true;
                    queue.add(adjVertex.get(i));
                }

            }

        }

    }


    public static void main(String[] args) {

        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);

        bfs.traversal(1);

    }


}
