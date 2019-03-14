package edu.stronglyconnectedcomponents.kosaraju;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Edge> neighbors;

    public Vertex(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
