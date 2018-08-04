package Graphs.Graph_Implementation;

import java.util.LinkedList;

public class DFS {

    private int numVertex;
    private LinkedList<Integer>[] adjList;
    private boolean[] isVisited;

    private DFS(int numVertex) {
        this.numVertex = numVertex;
        adjList = new LinkedList[numVertex];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        isVisited = new boolean[numVertex];
    }


    private void addEdge(int u, int v) {

        adjList[u].add(v);

    }


    private void traversal(int source) {


        System.out.print(source + " ");
        isVisited[source] = true;
        LinkedList<Integer> adjU = adjList[source];

        for (int e : adjU) {

            if (!isVisited[e]) {
                traversal(e);
            }

        }

    }

    public static void main(String[] args) {

        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);

        dfs.traversal(1);

    }
}
