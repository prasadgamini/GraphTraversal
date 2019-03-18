package edu.stronglyconnectedcomponents.kosaraju;

import java.util.List;

public class KosarajuApp {
    public static void main(String[] args) {
        System.out.println("==START==");

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");
        Vertex vertexH = new Vertex("H");


        Graph graph = new Graph();

        graph.addEdges(new Edge(7, vertexA, vertexC),
                new Edge(8, vertexB, vertexA),
                new Edge(3, vertexB, vertexD),
                new Edge(6, vertexA, vertexB),
                new Edge(4, vertexC, vertexB),
                new Edge(3, vertexC, vertexD),
                new Edge(2, vertexC, vertexE),
                new Edge(5, vertexD, vertexF),
                new Edge(2, vertexE, vertexG),
                new Edge(2, vertexE, vertexF),
                new Edge(2, vertexF, vertexD),
                new Edge(2, vertexG, vertexH),
                new Edge(2, vertexG, vertexE),
                new Edge(2, vertexH, vertexG),
                new Edge(2, vertexH, vertexF)


        );

        KosarajuAlgo kosarajuAlgo = new KosarajuAlgo();
        List<List<Vertex>> sccList = kosarajuAlgo.getSCCs(graph);
        System.out.println(sccList);

        System.out.println("==END==");
    }
}
