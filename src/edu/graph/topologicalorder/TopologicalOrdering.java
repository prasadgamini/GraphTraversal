package edu.graph.topologicalorder;

import edu.graph.pojo.Vertex;

import java.util.Stack;

public class TopologicalOrdering {
    Stack<Vertex> stack = new Stack<>();

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);
        for (Vertex neighbor : vertex.getNeighborsList()) {
            if (!neighbor.isVisited())
                dfs(neighbor);
        }
        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return stack;
    }
}
