package edu.minimumspanningtree.kruskal.primseagar;

import java.util.PriorityQueue;

public class PrimsEagerAlgo {

    private PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

    public void spanningTree(Graph graph) {

        graph.getVertices().forEach(vertex -> {
            if (!vertex.isVisited()) {
                vertex.setDistance(0);
                priorityQueue.add(vertex);

                while (!priorityQueue.isEmpty()) {
                    Vertex v = priorityQueue.remove();
                    //scan the vertex
                    v.setVisited(true);
                    v.getNeighbors().forEach(edge -> {
                        Vertex targetVertex = edge.getTargetVertex();
                        if (targetVertex.isVisited()) return; // continue in case of loop. :)
                        if (edge.getWeight() < targetVertex.getDistance()) {
                            targetVertex.setDistance(edge.getWeight());
                            targetVertex.setMinEdge(edge);
                            if (priorityQueue.contains(targetVertex)) {
                                priorityQueue.remove(targetVertex);
                            }
                            priorityQueue.add(targetVertex);
                        }
                    });
                }
            }
        });

        graph.getVertices().forEach(vertex -> {
            Edge minEdge = vertex.getMinEdge();
            if (minEdge != null) {
                System.out.println(minEdge.getStartVertex() + "--" + minEdge.getWeight() + "--" + minEdge.getTargetVertex());
            }
        });

        System.out.println("Total weight --> " + graph.getVertices().stream().mapToDouble(Vertex::getDistance).sum());
    }
}
