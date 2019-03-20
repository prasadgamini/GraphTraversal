package edu.stronglyconnectedcomponents.tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {

    private Stack<Vertex> stack;
    private List<List<Vertex>> sccList;
    private List<Vertex> vertices;
    private int id;
    private int sccCount;

    public TarjanAlgorithm(List<Vertex> vertices) {
        this.vertices = vertices;
        this.sccList = new ArrayList<>();
        this.stack = new Stack<>();
        this.id = 0;
        this.sccCount = 0;

        runAlgo();
    }

    public void runAlgo() {
        vertices.forEach(vertex -> {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        });
    }

    private void dfs(Vertex vertex) {
        vertex.setLowLinkValue(id++);
        vertex.setVisited(true);
        stack.push(vertex);
        boolean isSCCRoot = true;

        for(Vertex neighborVertex: vertex.getNeighbors()){
            if (!neighborVertex.isVisited()) {
                dfs(neighborVertex);
            }
            //After visiting all neighbors
            if(vertex.getLowLinkValue() > neighborVertex.getLowLinkValue()) {
                vertex.setLowLinkValue(neighborVertex.getLowLinkValue());
                isSCCRoot = false;
            }
        }

        if(isSCCRoot) {
            sccCount++;
            Vertex vertexFromStack = null;
            List<Vertex> scc = new ArrayList<>();
            do {
                vertexFromStack = stack.pop();
                scc.add(vertexFromStack);
                vertexFromStack.setLowLinkValue(Integer.MAX_VALUE);
            } while (!vertexFromStack.getName().equals(vertex.getName()));

            sccList.add(scc);
        }
    }

    public List<List<Vertex>> getSCCList() {
        return sccList;
    }
}
