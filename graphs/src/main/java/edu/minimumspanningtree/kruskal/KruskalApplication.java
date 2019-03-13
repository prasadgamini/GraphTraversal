package edu.minimumspanningtree.kruskal;

import java.util.Arrays;
import java.util.List;

public class KruskalApplication {

    public static void main(String[] args) {
        Vertex vertexS = new Vertex("S");
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexT = new Vertex("T");

        List<Edge> edges = Arrays.asList(new Edge(7, vertexS, vertexA),
                new Edge(8, vertexS, vertexC),
                new Edge(3, vertexA, vertexC),
                new Edge(6, vertexA, vertexB),
                new Edge(4, vertexC, vertexB),
                new Edge(3, vertexC, vertexD),
                new Edge(2, vertexB, vertexD),
                new Edge(5, vertexB, vertexT),
                new Edge(2, vertexD, vertexT));


        KruskalAlgo kruskalAlgo = new KruskalAlgo();
        kruskalAlgo.mst(Arrays.asList(vertexS, vertexA, vertexB, vertexC, vertexD, vertexT), edges);
    }
}
