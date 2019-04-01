package edu.maximumflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowNetwork {

    private Map<Vertex, List<Edge>> vertexNeighborEdgesMap; // edge from Vertex and also edge to Vertex is also added here

    public FlowNetwork(){
        vertexNeighborEdgesMap = new HashMap<>();
    }

    public List<Edge> getNeighborEdges(Vertex v) {
        return vertexNeighborEdgesMap.get(v);
    }

    public void addEdge(Edge edge){
        Vertex fromVertex = edge.getFromVertex();
        if(!vertexNeighborEdgesMap.containsKey(fromVertex)) {
            vertexNeighborEdgesMap.put(fromVertex, new ArrayList<>());
        }
        vertexNeighborEdgesMap.get(fromVertex).add(edge);
    }
}
