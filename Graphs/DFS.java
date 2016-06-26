package Graphs;


import Graphs.graph.Edge;
import Graphs.graph.Graph;
import Graphs.graph.Vertex;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFS {
    
    public static Vertex adjacent_unvisited_vertex(Vertex vertex){
        List edges = vertex.edges();
        if (edges.isEmpty()) {
            return null;
        }
        for (Iterator iterator = edges.iterator(); iterator.hasNext();) {
            Edge next = (Edge) iterator.next();
            if(!next.toNode().isVisited()){
                return next.toNode();
            }
        }
        return null;
    }

    private static void dfs(Graph<Integer> g, Vertex<Integer> root) {
        Stack<Vertex<Integer>> visited = new Stack<>();
        g.resetGraph();
        root.setVisited(true);
        visited.push(root);
        System.out.print(root.vertex() + " ,");
        while (!visited.isEmpty()) {
            Vertex vertex = adjacent_unvisited_vertex(visited.peek()) ;   
            if (vertex == null) {
                visited.pop();
            } else {                     
                vertex.setVisited(true);
                System.out.print(vertex.vertex() + " ,");
                visited.push(vertex);
            }
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
        dfs(g, g.getNode(0));
    }

}
