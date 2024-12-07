package com.teamai.hackitall.instorepicking;

import java.util.*;

class InstorePicker {
    public static Map<String, Integer> shortestPath(Graph graph, String start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!visited.add(current.name)) continue;

            for (Edge edge : graph.getNeighbors(current.name)) {
                if (visited.contains(edge.getTo())) continue;

                int newDist = distances.get(current.name) + edge.getWeight();
                if (newDist < distances.get(edge.getTo())) {
                    distances.put(edge.getTo(), newDist);
                    queue.add(new Node(edge.getTo(), newDist));
                }
            }
        }
        return distances;
    }
}

class Node {
    String name;
    int weight;

    public Node(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

