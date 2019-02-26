package edu.graph.kruskal;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    private int nodeCount;
    private int numOfDisJointSets;

    private List<DJSNode> representativeNodes;  // Root nodes of different sets

    public DisjointSet(List<Vertex> vertices) {
        nodeCount = 0;
        numOfDisJointSets = 0;
        representativeNodes = new ArrayList<>();
        vertices.forEach(this::makeSet);
    }

    private void makeSet(Vertex vertex) {
        DJSNode node = new DJSNode(vertex.getName(), 0, null);
        node.setParent(node);
        vertex.setNode(node);
        representativeNodes.add(node);
        nodeCount++;
        numOfDisJointSets++;
    }

    public DJSNode find(DJSNode node) {

        if(node.getParent() !=node) {
            node.setParent(find(node.getParent()));
        }
        return node.getParent();
    }

    public void union(DJSNode node1, DJSNode node2) {

        DJSNode rootNode1 = find(node1);
        DJSNode rootNode2 = find(node2);
        if (rootNode1.equals(rootNode2)) return;

        if (rootNode1.getRank() < rootNode2.getRank()) {
            rootNode1.setParent(rootNode2);
        } else if (rootNode1.getRank() > rootNode2.getRank()) {
            rootNode2.setParent(rootNode1);
        } else {
            rootNode2.setParent(rootNode1);
            rootNode1.setRank(rootNode1.getRank() + 1);
        }
        numOfDisJointSets--;
    }

}
