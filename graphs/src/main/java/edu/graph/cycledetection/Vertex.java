package edu.graph.cycledetection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private int data;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex> neighborsList;

    public Vertex(int data) {
        this.data = data;
        neighborsList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighborsList() {
        return neighborsList;
    }

    public void setNeighborsList(List<Vertex> neighborsList) {
        this.neighborsList = neighborsList;
    }

    public void addNeighborVertices(Vertex... vertices) {
        Arrays.stream(vertices).forEach(vertex -> this.neighborsList.add(vertex));
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
