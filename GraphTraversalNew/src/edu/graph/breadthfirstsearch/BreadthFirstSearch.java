package edu.graph.breadthfirstsearch;

import edu.graph.pojo.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void search(Vertex rootVertext) {
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(rootVertext);
        System.out.println(rootVertext.getData());
        rootVertext.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            for (Vertex neighborVertex : currentVertex.getNeighborsList()) {
                if(!neighborVertex.isVisited()) {
                    queue.add(neighborVertex);
                    System.out.println(neighborVertex.getData());
                    neighborVertex.setVisited(true);
                }
            }
        }
    }
}
