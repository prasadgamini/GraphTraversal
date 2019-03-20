package edu.stronglyconnectedcomponents.tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private Vertex predecessor;
    private String name;
    private List<Vertex> neighbors;
    private boolean visited;
    private int lowLinkValue;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbors(Vertex... vertices) {
        Arrays.stream(vertices).forEach(vertex -> this.neighbors.add(vertex));
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getLowLinkValue() {
        return lowLinkValue;
    }

    public void setLowLinkValue(int lowLinkValue) {
        this.lowLinkValue = lowLinkValue;
    }

    @Override
    public String toString() {
        return name;
    }
}
