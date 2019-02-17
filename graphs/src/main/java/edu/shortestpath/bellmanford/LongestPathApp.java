package edu.shortestpath.bellmanford;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;

import java.util.ArrayList;
import java.util.List;

public class LongestPathApp {


    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));
        vertices.add(new Vertex("D"));
        vertices.add(new Vertex("E"));
        vertices.add(new Vertex("F"));
        vertices.add(new Vertex("G"));

        List<Edge> edges = new ArrayList<>();
        //Negate the edge weights
        edges.add(new Edge(-1, vertices.get(0), vertices.get(1)));
        edges.add(new Edge(-2, vertices.get(0), vertices.get(3)));
        edges.add(new Edge(-6, vertices.get(1), vertices.get(2)));
        edges.add(new Edge(-1, vertices.get(2), vertices.get(4)));
        edges.add(new Edge(-2, vertices.get(2), vertices.get(5)));
        edges.add(new Edge(-4, vertices.get(3), vertices.get(1)));
        edges.add(new Edge(-3, vertices.get(3), vertices.get(4)));
        edges.add(new Edge(-1, vertices.get(4), vertices.get(5)));

        BellmanFordAlgo algo = new BellmanFordAlgo(vertices, edges, vertices.get(0));
        System.out.println(algo.getShortestPathTo(vertices.get(5)));
    }
}
