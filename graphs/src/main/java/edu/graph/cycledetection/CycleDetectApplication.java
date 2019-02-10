package edu.graph.cycledetection;

import java.util.Arrays;
import java.util.List;

public class CycleDetectApplication {


    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        v1.addNeighborVertices(v2, v3);
        v2.addNeighborVertices(v3);
//        v3.addNeighborVertices(v1);

        v4.addNeighborVertices(v1, v5);
        v5.addNeighborVertices(v6);
        v6.addNeighborVertices(v4);

        List<Vertex> graph = Arrays.asList(v1, v2, v3, v4, v5, v6);
        new CycleDetection().detectCycle(graph);
    }
}
