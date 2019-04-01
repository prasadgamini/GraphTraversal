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

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

//    public int getRecidualCapacityWithRespectTo(Vertex vertex) {
//        if (vertex == fromVertex) {
//            return flow; // backward edge in residual graph
//        } else {
//            return capacity - flow; // forward edge in residual graph
//        }
//    }

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
        return fromVertex + " - " + flow + " / " + capacity + " - " + toVertex;
    }
}
