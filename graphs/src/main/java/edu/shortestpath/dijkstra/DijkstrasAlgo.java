package edu.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgo {


    public DijkstrasAlgo(Vertex sourceVertex) {
        computeShortestPaths(sourceVertex);
    }

    public void computeShortestPaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0.0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(); // Default implementation give the elements in natural order.
        // This is min heap

        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();

            for (Edge edge : currentVertex.getNeighborList()) {
                Vertex neighborVertex = edge.getTargetVertex();
                double newDistance = currentVertex.getDistance() + edge.getWeight();
                if (newDistance < neighborVertex.getDistance()) {
                    priorityQueue.remove(neighborVertex); // this might be for reheap purpose
                    neighborVertex.setDistance(newDistance);
                    neighborVertex.setPredecessor(currentVertex);
                    priorityQueue.add(neighborVertex);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {

        List<Vertex> shortestPath = new ArrayList<>();
        for (Vertex v = targetVertex; v != null; v = v.getPredecessor()) {
            shortestPath.add(v);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
