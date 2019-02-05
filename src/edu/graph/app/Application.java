package edu.graph.app;

import edu.graph.breadthfirstsearch.BreadthFirstSearch;
import edu.graph.pojo.Vertex;
import edu.grapth.depthfirstsearch.DepthFirstSearch;

public class Application {

    public static void main(String[] args) {
        new BreadthFirstSearch().search(createGraph());
        System.out.println("==========================");
        new DepthFirstSearch().search(createGraph());
    }

    private static Vertex createGraph() {
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
