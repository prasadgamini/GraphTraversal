package edu.aliean;

public class Vertex {
    char ch;
    boolean visited;
    Vertex neighbor;

    public Vertex(char ch) {
        this.ch = ch;
    }

    public Vertex getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(Vertex neighbor) {
        this.neighbor = neighbor;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
