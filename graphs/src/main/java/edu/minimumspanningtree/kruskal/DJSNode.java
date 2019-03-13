package edu.minimumspanningtree.kruskal;

/**
 * DisJoint Set Node
 */
public class DJSNode {

    private String name;
    private int rank; // Represents the depth of the node (tree height for root node)
    private DJSNode parent;

    public DJSNode(String name, DJSNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public DJSNode(String name, int rank, DJSNode parent) {
        this.name = name;
        this.rank = rank;
        this.parent = parent;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public DJSNode getParent() {
        return parent;
    }

    public void setParent(DJSNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }
}
