package edu.minimumspanningtree.kruskal.primseagar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVerteces(Vertex... vertices) {
        Arrays.stream(vertices).forEach(vertex -> this.vertices.add(vertex));
    }

    public void addEdges(Edge... edges) {
        Arrays.stream(edges).forEach(this::addEdge);
    }

    public void addEdge(Edge edge) {
        Vertex startVertex = edge.getStartVertex();
        Vertex targetVertex = edge.getTargetVertex();

        startVertex.addNeighbors(new Edge(edge.getWeight(), startVertex, targetVertex));
        targetVertex.addNeighbors(new Edge(edge.getWeight(), targetVertex, startVertex));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
