package edu.maximumflow;

public class FordFulkersonApp {

    public static void main(String[] args) {
        Vertex vertexS = new Vertex("s");
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexT = new Vertex("t");

        FlowNetwork flowNetwork = new FlowNetwork();
        flowNetwork.addEdge(new Edge(vertexS, vertexA,4));
        flowNetwork.addEdge(new Edge(vertexS, vertexB,5));
        flowNetwork.addEdge(new Edge(vertexB, vertexA,4));
        flowNetwork.addEdge(new Edge(vertexA, vertexT,7));
        flowNetwork.addEdge(new Edge(vertexB, vertexT,1));

        FordFulkersonAlgo fordFulkersonAlgo = new FordFulkersonAlgo(flowNetwork, vertexS, vertexT);
        System.out.println(fordFulkersonAlgo.getMaxFlow());
    }
}
