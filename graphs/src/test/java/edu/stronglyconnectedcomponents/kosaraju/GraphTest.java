package edu.stronglyconnectedcomponents.kosaraju;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GraphTest {

    @Test
    public void testTranspose() {
        Vertex vertexS = new Vertex("S");
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexT = new Vertex("T");

        Graph graph = new Graph();

        graph.addEdges(new Edge(7, vertexS, vertexA),
                new Edge(8, vertexS, vertexC),
                new Edge(3, vertexA, vertexC),
                new Edge(6, vertexA, vertexB),
                new Edge(4, vertexC, vertexB),
                new Edge(3, vertexC, vertexD),
                new Edge(2, vertexB, vertexD),
                new Edge(5, vertexB, vertexT),
                new Edge(2, vertexD, vertexT));

        vertexS.setVisited(true);
        vertexA.setVisited(true);
        vertexB.setVisited(true);
        vertexC.setVisited(true);
        vertexD.setVisited(true);
        vertexT.setVisited(true);

        Graph transposeGraph = graph.transpose();

        for (int i = 0; i < graph.getEdges().size(); i++) {
            Edge edge = graph.getEdges().get(i);
            Edge reverseEdge = transposeGraph.getEdges().get(i);

            assertEquals(edge.getWeight(), reverseEdge.getWeight(),0.0);
            assertEquals(edge.getTargetVertex().getName(), reverseEdge.getStartVertex().getName());
            assertEquals(edge.getStartVertex().getName(), reverseEdge.getTargetVertex().getName());
        }

        transposeGraph.getVertices().forEach(vertex -> {
            assertFalse(vertex.isVisited());
        });
    }
}