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
        } else {
            startVertex = this.getVertex(startVertex.getName());
        }
        if (!vertices.contains(targetVertex)) {
            vertices.add(targetVertex);
        } else {
            targetVertex = this.getVertex(targetVertex.getName());
        }
        startVertex.addNeighbors(edge);
        this.edges.add(edge);
    }

    public Graph transpose() {

        Graph transposeGraph = new Graph();

        for (Edge edge : this.edges) {
            Vertex startVertex = transposeGraph.getVertex(edge.getStartVertex().getName());
            if (startVertex == null) startVertex = new Vertex(edge.getStartVertex().getName());

            Vertex targetVertex = transposeGraph.getVertex(edge.getTargetVertex().getName());
            if (targetVertex == null) targetVertex = new Vertex(edge.getTargetVertex().getName());
            transposeGraph.addEdge(new Edge(edge.getWeight(), targetVertex, startVertex));

        }
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

    public Vertex getVertex(String name) {
        for (Vertex v : vertices) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }
}
