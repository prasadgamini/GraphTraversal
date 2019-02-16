package edu.shortestpath.bellmanford;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;

import java.util.Arrays;
import java.util.List;

public class BellmanFordApplication {

    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");

        Edge edge1 = new Edge(1, vertexA, vertexB);
        vertexA.addNeighbor(edge1);
        Edge edge2 = new Edge(10, vertexA, vertexC);
        vertexA.addNeighbor(edge2);
        Edge edge3 = new Edge(1, vertexB, vertexC);
        vertexB.addNeighbor(edge3);
        Edge edge4 = new Edge(-3, vertexC, vertexA);
        vertexC.addNeighbor(edge4);

        List<Vertex> vertices = Arrays.asList(vertexA, vertexB, vertexC);
        List<Edge> edges = Arrays.asList(edge1, edge2, edge3, edge4);
        BellmanFordAlgo algo = new BellmanFordAlgo(vertices, edges, vertexA);
        System.out.println("-------------------");
        System.out.println(algo.getShortestPathTo(vertexC));
    }
}
