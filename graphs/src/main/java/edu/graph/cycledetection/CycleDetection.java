package edu.graph.cycledetection;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> graph) {

        graph.stream().forEach(vertex -> {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        });
    }

    private void dfs(Vertex vertex) {
        System.out.println("DFS on vertex : " + vertex);
        vertex.setBeingVisited(true);
        vertex.setVisited(false);

        for (Vertex neighbor: vertex.getNeighborsList()) {
            if(neighbor.isBeingVisited()) {
                System.out.println("We found a CYCLE backward edge : " + vertex + " , " + neighbor);
                return;
            }

            if(!neighbor.isVisited()) {
                neighbor.setVisited(true);
                dfs(neighbor);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
