package edu.minimumspanningtree.kruskal;

public class Vertex {

    private String name;
    private DJSNode node;

    public Vertex(String name) {
        this.name = name;
    }

    public Vertex(String name, DJSNode node) {
        this.name = name;
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DJSNode getNode() {
        return node;
    }

    public void setNode(DJSNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return name;
    }
}
