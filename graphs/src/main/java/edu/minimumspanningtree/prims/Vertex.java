package edu.minimumspanningtree.prims;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private Vertex previousVertex;
    private List<Edge> neighbors;

    public Vertex(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Edge edge) {
        this.neighbors.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbors(Edge... edges) {
        Arrays.stream(edges).forEach(edge -> this.neighbors.add(edge));
    }

    @Override
    public String toString() {
        return name;
    }
}
