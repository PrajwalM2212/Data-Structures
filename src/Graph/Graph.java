package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int numNodes;
    private List<Integer>[] adjList;


    public Graph(int numNodes) {

        this.numNodes = numNodes;
        this.adjList = new List[numNodes];

        for (List<Integer> list : adjList) {
            list = new ArrayList<>();
        }

    }

    private void addEdge(int u, int v, boolean isDirected) {

        if (isDirected) {

            if (adjList[u] == null) {
                adjList[u] = new ArrayList<>();
            }
            adjList[u].add(v);

        } else {
            if (adjList[u] == null) {
                adjList[u] = new ArrayList<>();
            }
            if (adjList[v] == null) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            adjList[v].add(u);

        }

    }

    private void display() {

        for (List list : adjList) {

            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i) + " ");

            }
            System.out.println("\n");

        }


    }


    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 2, false);
        graph.addEdge(0, 3, false);
        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(2, 6, true);
        graph.display();

    }
}
