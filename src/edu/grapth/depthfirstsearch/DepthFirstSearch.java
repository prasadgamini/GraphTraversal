package edu.grapth.depthfirstsearch;

import edu.graph.pojo.Vertex;

import java.util.Stack;

public class DepthFirstSearch {

    public void search(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        root.setVisited(true);

        while(!stack.empty()) {
            Vertex currentVertex = stack.pop();
            System.out.println(currentVertex.getData());
            for(Vertex neighborVertex : currentVertex.getNeighborsList()) {
                if(!neighborVertex.isVisited()) {
                    stack.push(neighborVertex);
                    neighborVertex.setVisited(true);
                }
            }
        }
    }
}
