package com.teamai.hackitall.instorepicking;

import java.util.*;

class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
        adjacencyList.get(to).add(new Edge(from, weight));
    }

    public List<Edge> getNeighbors(String node) {
        return adjacencyList.get(node);
    }

    public Set<String> getNodes() {
        return adjacencyList.keySet();
    }
}
