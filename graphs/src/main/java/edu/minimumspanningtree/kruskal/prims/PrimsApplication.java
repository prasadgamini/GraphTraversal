package edu.minimumspanningtree.kruskal.prims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsApplication {

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

        vertexS.addNeighbors(new Edge(7, vertexS, vertexA), new Edge(8, vertexS, vertexC));
        vertexA.addNeighbors(new Edge(3, vertexA, vertexC),  new Edge(6, vertexA, vertexB), new Edge(7, vertexA, vertexS));
        vertexB.addNeighbors(new Edge(2, vertexB, vertexD),   new Edge(5, vertexB, vertexT), new Edge(6, vertexB, vertexA), new Edge(4, vertexB, vertexC), new Edge(2, vertexB, vertexD));
        vertexC.addNeighbors(new Edge(4, vertexC, vertexB),   new Edge(3, vertexC, vertexD), new Edge(8, vertexC, vertexS), new Edge(3, vertexC, vertexA));
        vertexD.addNeighbors(new Edge(2, vertexD, vertexT), new Edge(2, vertexD, vertexB),  new Edge(3, vertexD, vertexC));
        vertexT.addNeighbors( new Edge(5, vertexT, vertexB), new Edge(2, vertexT, vertexD));


        PrimsAlgo primsAlgo = new PrimsAlgo(new ArrayList<>(Arrays.asList(vertexS,vertexA, vertexB, vertexC, vertexD, vertexT)));
        primsAlgo.mst(vertexS);
    }
}
