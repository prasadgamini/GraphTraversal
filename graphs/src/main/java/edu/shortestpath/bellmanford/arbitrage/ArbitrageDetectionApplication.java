package edu.shortestpath.bellmanford.arbitrage;

import edu.shortestpath.Edge;
import edu.shortestpath.Vertex;

import java.util.ArrayList;
import java.util.List;

public class ArbitrageDetectionApplication {

    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("USD"));//United States Dollar
        vertices.add(new Vertex("EUR"));//The euro (sign: €; code: EUR) is the official currency of 19 of the 28 member states of the European Union.
        vertices.add(new Vertex("GBP"));//Great Britain Pound
        vertices.add(new Vertex("CHF"));//Confoederatio Helvetica Franc (CHF is the abbreviation for the Swiss franc)
        vertices.add(new Vertex("CAD"));//Canadian dollar

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(-1 * Math.log(0.741), vertices.get(0), vertices.get(1)));
        edges.add(new Edge(-1 * Math.log(0.657), vertices.get(0), vertices.get(2)));
        edges.add(new Edge(-1 * Math.log(1.061), vertices.get(0), vertices.get(3)));
        edges.add(new Edge(-1 * Math.log(1.005), vertices.get(0), vertices.get(4)));

        edges.add(new Edge(-1 * Math.log(1.349), vertices.get(1), vertices.get(0)));
        edges.add(new Edge(-1 * Math.log(0.888), vertices.get(1), vertices.get(2)));
        edges.add(new Edge(-1 * Math.log(1.433), vertices.get(1), vertices.get(3)));
        edges.add(new Edge(-1 * Math.log(1.366), vertices.get(1), vertices.get(4)));

        edges.add(new Edge(-1 * Math.log(1.521), vertices.get(2), vertices.get(0)));
        edges.add(new Edge(-1 * Math.log(1.126), vertices.get(2), vertices.get(1)));
        edges.add(new Edge(-1 * Math.log(1.614), vertices.get(2), vertices.get(3)));
        edges.add(new Edge(-1 * Math.log(1.538), vertices.get(2), vertices.get(4)));

        edges.add(new Edge(-1 * Math.log(0.942), vertices.get(3), vertices.get(0)));
        edges.add(new Edge(-1 * Math.log(0.698), vertices.get(3), vertices.get(1)));
        edges.add(new Edge(-1 * Math.log(0.619), vertices.get(3), vertices.get(2)));
        edges.add(new Edge(-1 * Math.log(0.953), vertices.get(3), vertices.get(4)));

        edges.add(new Edge(-1 * Math.log(0.995), vertices.get(4), vertices.get(0)));
        edges.add(new Edge(-1 * Math.log(0.732), vertices.get(4), vertices.get(1)));
        edges.add(new Edge(-1 * Math.log(0.650), vertices.get(4), vertices.get(2)));
        edges.add(new Edge(-1 * Math.log(1.049), vertices.get(4), vertices.get(3)));

        BellmanFordAlgo bellmanFordAlgo = new BellmanFordAlgo(vertices, edges, vertices.get(0));
        System.out.println("Arbitrage :: " + bellmanFordAlgo.getCycleList());



    }
}
