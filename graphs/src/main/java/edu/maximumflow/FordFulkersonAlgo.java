package edu.maximumflow;

import java.util.*;

public class FordFulkersonAlgo {
    Map<Vertex, Edge> toVertexEdgeMap;  // A->B edge is stored against B... reverse tracking purpose.
    Set<Vertex> visitedVertexSet; // visited verteces are added to this set.

    private int maxFlow ;
    public FordFulkersonAlgo(FlowNetwork flowNetwork, Vertex s, Vertex t) {
        maxFlow = 0;
        while (hasAugmentingPath(flowNetwork, s, t)) {
            List<Edge> edgeList = new ArrayList<>();
            int minFlow = Integer.MAX_VALUE;
            for (Vertex v = t; v != s; v = toVertexEdgeMap.get(v).getFromVertex()) { // reverse tracking
                Edge edge = toVertexEdgeMap.get(v);
                edgeList.add(edge);
                minFlow = Math.min(minFlow, edge.getRecidualCapacity());
            }
            System.out.println(edgeList);
            for (Edge edge: edgeList) {
                edge.addFlow(minFlow);
            }
            maxFlow += minFlow;
        }
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex s, Vertex t) {
        toVertexEdgeMap = new HashMap<>();
        visitedVertexSet = new HashSet<>();

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty() && !visitedVertexSet.contains(t)) {
            Vertex fromVertex = queue.remove();
            List<Edge> neighborEdges = flowNetwork.getNeighborEdges(fromVertex);
            if(neighborEdges!=null) {
                for (Edge edge : neighborEdges) {
                    if (edge.getRecidualCapacity() > 0) {
                        Vertex toVertex = edge.getToVertex();
                        visitedVertexSet.add(toVertex);
                        toVertexEdgeMap.put(toVertex, edge);
                        queue.add(toVertex);
                    }
                }
            }
        }
        return visitedVertexSet.contains(t);
    }
}
