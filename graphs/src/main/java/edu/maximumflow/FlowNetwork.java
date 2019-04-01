package edu.maximumflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowNetwork {

    private int numOfVertices;
    private int numOfEdges;
    private Map<Vertex, List<Edge>> vertexNeighborEdgesMap; // edge from Vertex and also edge to Vertex is also added here

    public FlowNetwork(){
        this.numOfEdges = 0;
        vertexNeighborEdgesMap = new HashMap<>();
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public List<Edge> getNeighborEdges(Vertex v) {
        return vertexNeighborEdgesMap.get(v);
    }

    public void addEdge(Edge edge){
        Vertex fromVertex = edge.getFromVertex();
        Vertex toVertex = edge.getToVertex();
        if(!vertexNeighborEdgesMap.containsKey(fromVertex)) {
            vertexNeighborEdgesMap.put(fromVertex, new ArrayList<>());
        }
//        if(!vertexNeighborEdgesMap.containsKey(toVertex)) {
//            vertexNeighborEdgesMap.put(toVertex, new ArrayList<>());
//        }
        vertexNeighborEdgesMap.get(fromVertex).add(edge);
//        vertexNeighborEdgesMap.get(toVertex).add(edge);
        numOfEdges++;
    }
}
