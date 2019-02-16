package edu.shortestpath.dagshortestpath;

import edu.shortestpath.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPathAlgo {

    public AcyclicShortestPathAlgo(List<Vertex> vertices, Vertex sourceVertex) {
        computeShortestPath(vertices, sourceVertex);
    }

    public void computeShortestPath(List<Vertex> vertices, Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        Stack<Vertex> stack = new TopologicalOrder(vertices).getTopologicalOrder();

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            vertex.getNeighborList().forEach(edge -> {
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                double newDistance = u.getDistance() + edge.getWeight();
                if(newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            });
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        if(targetVertex.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no path available from source");
            return null;
        }
        List<Vertex> shortestPath = new ArrayList<>();
        for (Vertex v = targetVertex; v != null; v = v.getPredecessor()) {
            shortestPath.add(v);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
