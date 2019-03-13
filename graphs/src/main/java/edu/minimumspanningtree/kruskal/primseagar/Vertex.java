package edu.minimumspanningtree.kruskal.primseagar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private Edge minEdge;
    private boolean visited;
    private double distance;
    private List<Edge> neighbors;

    public Vertex(String name) {
        this.name = name;
        distance = Double.POSITIVE_INFINITY;
        neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Edge getMinEdge() {
        return minEdge;
    }

    public void setMinEdge(Edge minEdge) {
        this.minEdge = minEdge;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.distance);
    }

    @Override
    public String toString() {
        return name;
    }
}
