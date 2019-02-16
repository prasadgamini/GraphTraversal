package edu.shortestpath.dagshortestpath;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;
import edu.shortestpath.bellmanford.BellmanFordAlgo;

import java.util.Arrays;
import java.util.List;

public class DAGApplication {


    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");

        Edge edge1 = new Edge(1, vertexA, vertexB);
        vertexA.addNeighbor(edge1);
        Edge edge2 = new Edge(12, vertexA, vertexC);
        vertexA.addNeighbor(edge2);
        Edge edge3 = new Edge(1, vertexB, vertexC);
        vertexB.addNeighbor(edge3);

        Edge edge4 = new Edge(1, vertexC, vertexD);
        vertexC.addNeighbor(edge4);


        List<Vertex> vertices = Arrays.asList(vertexA, vertexB, vertexC, vertexD);
        AcyclicShortestPathAlgo algo = new AcyclicShortestPathAlgo(vertices, vertexA);
        System.out.println("-------------------");
        System.out.println(algo.getShortestPathTo(vertexD));
    }
}
