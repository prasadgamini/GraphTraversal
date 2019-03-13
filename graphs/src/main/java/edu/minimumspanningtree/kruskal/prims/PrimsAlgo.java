package edu.minimumspanningtree.kruskal.prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {

    private List<Vertex> unvisitedVertices;
    private List<Edge> mst;
    private PriorityQueue<Edge> priorityQueue;
    private double fullcost;

    public PrimsAlgo(List<Vertex> unvisitedVertices) {
        this.unvisitedVertices = unvisitedVertices;
        mst = new ArrayList<>();
        priorityQueue = new PriorityQueue<>();
        fullcost = 0.0;
    }

    public void mst(Vertex vertex) {
        unvisitedVertices.remove(vertex);

        while (!unvisitedVertices.isEmpty()) {
            for (Edge edge : vertex.getNeighbors()) {
                if (unvisitedVertices.contains(edge.getTargetVertex())) {
                    priorityQueue.add(edge);
                }
            }

            Edge minEdge = priorityQueue.remove();
            this.mst.add(minEdge);
            fullcost += minEdge.getWeight();

            vertex = minEdge.getTargetVertex();
            unvisitedVertices.remove(vertex);
        }

        mst.forEach(System.out::println);
        System.out.println("Full cost :: " + fullcost);
    }
}
