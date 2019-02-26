package edu.graph.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgo {

    public void mst(List<Vertex> vertices, List<Edge> edges) {
        List<Edge> mstList = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(vertices);

        Collections.sort(edges);

        for (Edge edge : edges) {
            Vertex startVertex = edge.getStartVertex();
            Vertex targetVertex = edge.getTargetVertex();

            if (disjointSet.find(startVertex.getNode()) != disjointSet.find(targetVertex.getNode())) {
                mstList.add(edge);
                if (mstList.size() == vertices.size() - 1) break;
                disjointSet.union(startVertex.getNode(), targetVertex.getNode());
            }
        }
        System.out.println(mstList);
    }
}
