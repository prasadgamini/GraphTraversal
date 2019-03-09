package edu.graph.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgo {

    public List<Edge> mst(List<Vertex> vertices, List<Edge> edges) {
        List<Edge> mstList = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(vertices);
        double fullCost = 0.0;

        Collections.sort(edges);

        for (Edge edge : edges) {
            Vertex startVertex = edge.getStartVertex();
            Vertex targetVertex = edge.getTargetVertex();

            if (disjointSet.find(startVertex.getNode()) != disjointSet.find(targetVertex.getNode())) {
                mstList.add(edge);
                fullCost += edge.getWeight();
                if (mstList.size() == vertices.size() - 1) break;
                disjointSet.union(startVertex.getNode(), targetVertex.getNode());
            }
        }
//        System.out.println(mstList);
        mstList.forEach(System.out::println);
        System.out.println("Full cost :: " + fullCost);
        return mstList;
    }
}
