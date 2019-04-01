package edu.maximumflow;

public class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;
    private int flow;
    private int capacity;

    public Edge(Vertex fromVertex, Vertex toVertex, int capacity) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public int getRecidualCapacity() {
        return capacity - flow;
    }

    public void addFlow(int deltaFlow) {
        if (flow + deltaFlow > capacity) {
            throw new RuntimeException("Too much flow");
        }
        this.flow += deltaFlow;
    }

    @Override
    public String toString() {
        return fromVertex + " --" + flow + "/" + capacity + "--> " + toVertex;
    }
}
