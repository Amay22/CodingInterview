package graphs;

import graphs.graph.Graph;
import graphs.graph.Vertex;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static void bfs(Graph<Integer> g, Vertex<Integer> root) {
        g.resetGraph();
        Queue <Vertex>visited = new LinkedList();
        visited.add(root);
        System.out.print(root.vertex()+", ");
        while (!visited.isEmpty()) {
            Vertex<Integer> vertex = visited.remove();
            vertex.setVisited(true);
            vertex.edges().forEach(edge -> {
                Vertex neighbour = edge.toNode();
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    System.out.print(neighbour.vertex()+", ");
                    visited.add(neighbour);
                }
            });
        }
    }

    public static void main(String[] args) {
        Graph<Integer> g;
        g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(0, 8);
        g.addEdge(8, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 7);
        g.addEdge(7, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 2);
        g.addEdge(6, 5);
        g.addEdge(5, 6);
        g.addEdge(4, 8);
        g.addEdge(8, 4);
        g.addEdge(7, 1);
        g.addEdge(1, 7);
        bfs(g, g.getNode(0));
    }
}
