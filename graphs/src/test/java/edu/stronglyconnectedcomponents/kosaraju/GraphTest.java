package edu.stronglyconnectedcomponents.kosaraju;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testTranspose() {
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


        vertexA.setVisited(true);
        vertexB.setVisited(true);
        vertexC.setVisited(true);
        vertexD.setVisited(true);
        vertexE.setVisited(true);
        vertexF.setVisited(true);

        Graph transposeGraph = graph.transpose();

        for (int i = 0; i < graph.getEdges().size(); i++) {
            Edge edge = graph.getEdges().get(i);
            Edge reverseEdge = transposeGraph.getEdges().get(i);

            assertEquals(edge.getWeight(), reverseEdge.getWeight(),0.0);
            assertEquals(edge.getTargetVertex().getName(), reverseEdge.getStartVertex().getName());
            assertEquals(edge.getStartVertex().getName(), reverseEdge.getTargetVertex().getName());
            List<Edge> neighbors = transposeGraph.getVertex(edge.getTargetVertex().getName()).getNeighbors();
        }

        assertEquals("B", transposeGraph.getVertex("A").getNeighbors().get(0).getTargetVertex().getName());
        transposeGraph.getVertices().forEach(vertex -> {
            assertFalse(vertex.isVisited());
        });
    }
}