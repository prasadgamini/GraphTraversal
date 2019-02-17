package edu.shortestpath.bellmanford.arbitrage;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFordAlgo {
    private List<Vertex> vertices;
    private List<Edge> edges;
    private List<Vertex> cycleList;

    public BellmanFordAlgo(List<Vertex> vertices, List<Edge> edges, Vertex sourceVertex) {
        this.vertices = vertices;
        this.edges = edges;
        this.cycleList = new ArrayList<>();
        computeShortestPaths(sourceVertex);
    }

    private void computeShortestPaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0.0);

        for (int i = 0; i < vertices.size() - 1; i++) { // |v|-1 iterations , where is |v| is number of vertices

            for (Edge edge : edges) {
                Vertex startVertex = edge.getStartVertex();
                Vertex targetVertex = edge.getTargetVertex();

                if (startVertex.getDistance() == Double.MAX_VALUE) continue;

                double newDistance = startVertex.getDistance() + edge.getWeight();
                if (newDistance < targetVertex.getDistance()) {
                    targetVertex.setDistance(newDistance);
                    targetVertex.setPredecessor(startVertex);
                }
            }
        }

        for (Edge edge : edges) {
            if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
                if (hasNegativeCycle(edge)) {
                    System.err.println("Negative cycle found...");

                    Vertex vertex = edge.getStartVertex();
                    while(!vertex.equals(edge.getTargetVertex())){
                        cycleList.add(vertex);
                        vertex = vertex.getPredecessor();
                    }
                    this.cycleList.add(edge.getTargetVertex());
                    return;
                }
            }
        }

    }

    private boolean hasNegativeCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }


    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        if (targetVertex.getDistance() == Double.MAX_VALUE) {
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

    public List<Vertex> getCycleList(){
        return cycleList;
    }
}
