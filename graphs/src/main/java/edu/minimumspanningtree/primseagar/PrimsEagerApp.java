package edu.minimumspanningtree.primseagar;

public class PrimsEagerApp {
    public static void main(String[] args) {
        Vertex vertexS = new Vertex("S");
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexT = new Vertex("T");




        Graph graph = new Graph();
        graph.addVerteces(vertexS, vertexA, vertexB, vertexC, vertexD, vertexT);
        graph.addEdges(new Edge(7, vertexS, vertexA),
                new Edge(8, vertexS, vertexC),
                new Edge(3, vertexA, vertexC),
                new Edge(6, vertexA, vertexB),
                new Edge(4, vertexC, vertexB),
                new Edge(3, vertexC, vertexD),
                new Edge(2, vertexB, vertexD),
                new Edge(5, vertexB, vertexT),
                new Edge(2, vertexD, vertexT));

        PrimsEagerAlgo primsEagerAlgo = new PrimsEagerAlgo();
        primsEagerAlgo.spanningTree(graph);

    }
}
