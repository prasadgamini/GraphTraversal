package edu.stronglyconnectedcomponents.tarjan;

import java.util.Arrays;
import java.util.List;

public class TarjanApp {
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

        vertexA.addNeighbors(vertexB, vertexC);
        vertexB.addNeighbors(vertexA, vertexD);
        vertexC.addNeighbors(vertexB, vertexD, vertexE);
        vertexD.addNeighbors(vertexF);
        vertexE.addNeighbors(vertexG, vertexF);
        vertexF.addNeighbors(vertexD);
        vertexG.addNeighbors(vertexH, vertexE);
        vertexH.addNeighbors(vertexG, vertexF);

        TarjanAlgorithm tarjanAlgorithm = new TarjanAlgorithm(Arrays.asList(vertexA,vertexB,vertexC, vertexD, vertexE, vertexF, vertexG, vertexH));
        List<List<Vertex>> sccList = tarjanAlgorithm.getSCCList();
        System.out.println(sccList);

        System.out.println("==END==");
    }
}
