package edu.shortestpath.dijkstra;

public class DijkstraApplication {

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        vertexA.addNeighbor(new Edge(1, vertexA, vertexB));
        vertexA.addNeighbor(new Edge(10, vertexA, vertexC));
        vertexB.addNeighbor(new Edge(1, vertexB, vertexC));

        DijkstrasAlgo algo = new DijkstrasAlgo(vertexA);
        System.out.println("-------------------");
        System.out.println(algo.getShortestPathTo(vertexC));
    }
}
