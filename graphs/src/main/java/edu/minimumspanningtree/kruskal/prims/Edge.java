package edu.minimumspanningtree.kruskal.prims;


public class Edge implements Comparable<Edge> {
    private double weight;
    private Vertex startVertex; // Useful in bellman-ford algo, not required for dijkstra's algo
    private Vertex targetVertex;

    public Edge(double weight, Vertex targetVertex) {
        this.weight = weight;
        this.targetVertex = targetVertex;
    }

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return Double.compare(this.getWeight(), otherEdge.getWeight());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edge{");
        sb.append("weight=").append(weight);
        sb.append(", startVertex=").append(startVertex);
        sb.append(", targetVertex=").append(targetVertex);
        sb.append('}');
        return sb.toString();
    }
}
