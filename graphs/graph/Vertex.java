package graphs.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface VertexADT<T>{
    public T vertex();

    public boolean addEdge(Vertex<T> vertex, int weight);

    public boolean removeEdge(Vertex<T> vertex);

    public boolean hasEdge(Vertex<T> vertex);

    Optional<Edge<T>> findEdge(Vertex<T> vertex);

    public List<Edge<T>> edges();

    public int getEdgeCount();

    public Vertex<T> parent();

    public boolean isVisited();

    public void setVisited(boolean isVisited);

    public void setParent(Vertex<T> parent);
}

public class Vertex<T> implements VertexADT<T> {

    private final T vertex;

    private final List<Edge<T>> edges;

    private Vertex<T> parent;

    private boolean isVisited;

    public Vertex(T vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }

    @Override
    public T vertex() {
        return vertex;
    }

    @Override
    public boolean addEdge(Vertex<T> vert, int weight) {
        if (hasEdge(vert)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, vert, weight);
        return edges.add(newEdge);
    }

    @Override
    public boolean removeEdge(Vertex<T> vert) {
        Optional<Edge<T>> optional = findEdge(vert);
        if (optional.isPresent()) {
            return edges.remove(optional.get());
        }
        return false;
    }

    @Override
    public boolean hasEdge(Vertex<T> vert) {
        return findEdge(vert).isPresent();
    }

    /**
     *
     * @param vert
     * @return
     */
    @Override
    public Optional<Edge<T>> findEdge(Vertex<T> vert) {
        return edges.stream()
                .filter(edge -> edge.isBetween(this, vert))
                .findFirst();
    }

    @Override
    public List<Edge<T>> edges() {
        return edges;
    }

    @Override
    public int getEdgeCount() {
        return edges.size();
    }

    @Override
    public Vertex<T> parent() {
        return parent;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }

    @Override
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public void setParent(Vertex<T> parent) {
        this.parent = parent;
    }
}
