package Graphs.graph;

interface EdgeADT<T>{
    
    public Vertex<T> fromNode();
    
    public Vertex<T> toNode();
    
    public boolean isBetween(Vertex<T> vertex1, Vertex<T> vertex2);
    
}

public class Edge<T> implements EdgeADT<T>{

    private final Vertex<T> vertex1;

    private final Vertex<T> vertex2;

    private final int weight;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    @Override
    public Vertex<T> fromNode() {
        return vertex1;
    }

    @Override
    public Vertex<T> toNode() {
        return vertex2;
    }

    @Override
    public boolean isBetween(Vertex<T> vertex1, Vertex<T> vertex2) {
        return (this.vertex1 == vertex1 && this.vertex2 == vertex2);
    }
}
