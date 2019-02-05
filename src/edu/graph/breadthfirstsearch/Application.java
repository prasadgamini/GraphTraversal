package edu.graph.breadthfirstsearch;

import edu.graph.pojo.Vertex;

public class Application {

    public static void main(String[] args) {
        Vertex rootVertex = initGraph();
        new BreadthFirstSearch().search(rootVertex);
    }

    private static Vertex initGraph() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);


        vertex1.addNeighborVertices(vertex2, vertex4);
        vertex2.addNeighborVertices(vertex1, vertex3);
        vertex4.addNeighborVertices(vertex5);

        return vertex1;
    }
}
