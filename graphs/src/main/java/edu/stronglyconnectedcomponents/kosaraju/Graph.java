package edu.stronglyconnectedcomponents.kosaraju;

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
        if (!vertices.contains(startVertex)) {
            vertices.add(startVertex);
        }
        if (!vertices.contains(targetVertex)) {
            vertices.add(targetVertex);
        }
        startVertex.addNeighbors(edge);
        this.edges.add(edge);
    }

    public Graph transpose() {

        Graph transposeGraph = new Graph();
        this.edges.forEach(edge -> {
                    Vertex newTargetVertex = new Vertex(edge.getTargetVertex().getName());
                    Vertex newStartVertex = new Vertex(edge.getStartVertex().getName());
                    transposeGraph.addEdge(new Edge(edge.getWeight(), newTargetVertex, newStartVertex));
                }
        );
        return transposeGraph;
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
