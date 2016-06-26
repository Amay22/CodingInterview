package Graphs.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

interface GraphADT<T> {

    public boolean addVertex(T vertex);

    public boolean addEdge(T vertex1, T vertex2);

    public boolean addEdge(T vertex1, T vertex2, int weight);

    public boolean removeVertex(T vertex);

    public boolean removeEdge(T vertex1, T vertex2);

    public int vertexCount();

    public int edgeCount();

    public boolean containsVertex(T vertex);

    public boolean containsEdge(T vertex1, T vertex2);

    public List<T> shortestPath(T startVertex, T endVertex);

    void runBFS(T startVertex);

    Vertex<T> getNode(T value);

    void resetGraph();
}

public class Graph<T> implements GraphADT<T>{

    private final Map<T, Vertex<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex vertex to add
     * @return true if edge added else false
     */
    @Override
    public boolean addVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new Vertex<>(vertex));
        return true;
    }

    /**
     * Adds a directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @return true if edge added
     */
    @Override
    public boolean addEdge(T vertex1, T vertex2) {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @param weight weight of the edge
     * @return true if edge added
     */
    @Override
    public boolean addEdge(T vertex1, T vertex2, int weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        Vertex<T> node1 = getNode(vertex1);
        Vertex<T> node2 = getNode(vertex2);
        return node1.addEdge(node2, weight);
    }

    /**
     * Remove a vertex from the graph.
     *
     * @param vertex vertex to be removed
     * @return true if the vertex was removed, false if no such vertex was
     * found.
     */
    @Override
    public boolean removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        // get node to be removed
        final Vertex<T> toRemove = getNode(vertex);

        // remove all incoming edges to node
        adjacencyList.values().forEach(node -> node.removeEdge(toRemove));

        // remove the node
        adjacencyList.remove(vertex);
        return true;
    }

    /**
     * Method to remove a directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @return true if the edge was removed, false if no such edge was found.
     */
    @Override
    public boolean removeEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2));
    }

    /**
     * Method to get the number of vertices in the graph.
     *
     * @return count of vertices
     */
    @Override
    public int vertexCount() {
        return adjacencyList.keySet().size();
    }

    /**
     * Method to get the number of edges in the graph.
     *
     * @return count of edges
     */
    @Override
    public int edgeCount() {
        return adjacencyList.values()
                .stream()
                .mapToInt((vertex) -> vertex.getEdgeCount())
                .sum();
    }

    /**
     * Method to check if a vertex exists in the graph.
     *
     * @param vertex vertex which is to be checked
     * @return returns true if the graph contains the vertex, false otherwise
     */
    @Override
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Method to check if an edge exists in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @return returns true if the graph contains the edge, false otherwise
     */
    @Override
    public boolean containsEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    /**
     * Method to get the shortest path from startVertex to endVertex.
     *
     * @param startVertex vertex where the path begins
     * @param endVertex vertex where the path ends
     * @return list of vertices in the shortest path from startVertex to
     * endVertex, null if no such path exists.
     */
    @Override
    public List<T> shortestPath(T startVertex, T endVertex) {
        // if nodes not found, return empty path
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            return null;
        }
        // run bfs on the graph
        runBFS(startVertex);

        List<T> path = new ArrayList<>();
        // trace path back from end vertex to start
        Vertex<T> end = getNode(endVertex);
        while (end != null && end != getNode(startVertex)) {
            path.add(end.vertex());
            end = end.parent();
        }
        // if end is null, node not found
        if (end == null) {
            return null;
        } else {
            Collections.reverse(path);
        }
        return path;
    }

    @Override
    public void runBFS(T startVertex) {
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        // reset the graph
        resetGraph();

        // init the queue
        Queue<Vertex<T>> queue = new LinkedList<>();
        Vertex<T> start = getNode(startVertex);
        queue.add(start);

        // explore the graph
        while (!queue.isEmpty()) {
            Vertex<T> first = queue.remove();
            first.setVisited(true);
            first.edges().forEach(edge -> {
                Vertex<T> neighbour = edge.toNode();
                if (!neighbour.isVisited()) {
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            });
        }
    }

    @Override
    public Vertex<T> getNode(T value) {
        return adjacencyList.get(value);
    }

    @Override
    public void resetGraph() {
        adjacencyList.keySet().forEach(key -> {
            Vertex<T> vertex = getNode(key);
            vertex.setParent(null);
            vertex.setVisited(false);
        });
    }
}
