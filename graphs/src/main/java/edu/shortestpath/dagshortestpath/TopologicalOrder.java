package edu.shortestpath.dagshortestpath;

import edu.shortestpath.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalOrder {

    private Stack<Vertex> stack;

    public TopologicalOrder(List<Vertex> vertices) {
        stack = new Stack<>();
        computeTopologicalSort(vertices);
    }

    private void computeTopologicalSort(List<Vertex> vertices) {
        vertices.forEach(vertex -> {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        });
    }

    private void dfs(Vertex vertex) {
        vertex.getNeighborList().forEach(edge -> {
            if(!edge.getTargetVertex().isVisited()){
                edge.getTargetVertex().setVisited(true);
                dfs(edge.getTargetVertex());
            }
        });
        stack.push(vertex);
    }

    public Stack<Vertex> getTopologicalOrder() {
        return stack;
    }
}
