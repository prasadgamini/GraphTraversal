package edu.graph.topologicalorder;

import edu.graph.pojo.Vertex;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalOrderingApp {
    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

        List<Vertex> graph = Arrays.asList(new Vertex(0), new Vertex(1),
                new Vertex(2), new Vertex(3), new Vertex(4), new Vertex(5));

        graph.get(2).addNeighborVertices(graph.get(3));
        graph.get(3).addNeighborVertices(graph.get(1));
        graph.get(4).addNeighborVertices(graph.get(0));
        graph.get(4).addNeighborVertices(graph.get(1));
        graph.get(5).addNeighborVertices(graph.get(0));
        graph.get(5).addNeighborVertices(graph.get(2));

        for (Vertex vertex : graph) {
            if (!vertex.isVisited()) {
                topologicalOrdering.dfs(vertex);
            }
        }


        Stack<Vertex> stack = topologicalOrdering.getStack();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
