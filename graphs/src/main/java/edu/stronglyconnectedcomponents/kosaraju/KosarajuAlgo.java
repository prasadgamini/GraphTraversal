package edu.stronglyconnectedcomponents.kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {
    private Stack<Vertex> stack = new Stack<>();

    public List<List<Vertex>> getSCCs(Graph graph) {
        List<List<Vertex>> stronglyConnectedComponentsList = new ArrayList<>();

        graph.getVertices().forEach(vertex -> {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        });

        Graph transposeGraph = graph.transpose();
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            Vertex vertex1 = transposeGraph.getVertex(vertex.getName());
            if (!vertex1.isVisited()) {
                dfsOnTranspose(vertex1);
                System.out.println();
            }
        }

        return stronglyConnectedComponentsList;
    }

    public void dfs(Vertex vertex) {

        vertex.setVisited(true);
        for (Edge neighbor : vertex.getNeighbors()) {
            Vertex targetVertex = neighbor.getTargetVertex();
            if (!targetVertex.isVisited()) {
                dfs(targetVertex);
            }
        }
        stack.push(vertex);
    }

    public void dfsOnTranspose(Vertex vertex) {
        System.out.print(vertex.getName() + " === ");
        vertex.setVisited(true);
        for (Edge neighbor : vertex.getNeighbors()) {
            Vertex targetVertex = neighbor.getTargetVertex();

            if (!targetVertex.isVisited()) {
                dfsOnTranspose(targetVertex);
            }
        }

    }

}
