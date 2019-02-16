package edu.shortestpath.dijkstra;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;

public class DijkstraApplication {

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        vertexA.addNeighbor(new Edge(1, vertexB));
        vertexA.addNeighbor(new Edge(1, vertexC));
        vertexB.addNeighbor(new Edge(1, vertexC));

        DijkstrasAlgo algo = new DijkstrasAlgo(vertexA);
        System.out.println("-------------------");
        System.out.println(algo.getShortestPathTo(vertexC));
    }
}
