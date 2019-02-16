package edu.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> neighborList;
    private Vertex predecessor;
    private double distance;
    private boolean visited; //Used in DAG shortest path algo.

    public Vertex(String name) {
        this.name = name;
        neighborList = new ArrayList<>();
        distance = Double.MAX_VALUE;
    }

    public List<Edge> getNeighborList() {
        return neighborList;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void addNeighbor(Edge edge) {
        this.neighborList.add(edge);
    }

    public void addNeighbors(Edge... edges) {
        Arrays.stream(edges).forEach(edge -> this.neighborList.add(edge));
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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
