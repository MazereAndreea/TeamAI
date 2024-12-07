package com.teamai.hackitall.instorepicking;

import java.util.*;

class InstorePicker {
    public static Map<String, List<String>> shortestPath(Graph graph, String start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        Map<String, Integer> distances = new HashMap<>();
        Map<String, List<String>> paths = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
            paths.put(node, new ArrayList<>());
        }
        distances.put(start, 0);
        paths.get(start).add("Start");

        queue.add(new Node(start, 0, paths.get(start)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!visited.add(current.name)) continue;

            for (Edge edge : graph.getNeighbors(current.name)) {
                if (visited.contains(edge.getTo())) continue;

                int newDist = distances.get(current.name) + edge.getWeight();
                if (newDist < distances.get(edge.getTo())) {
                    distances.put(edge.getTo(), newDist);

                    List<String> newPath = new ArrayList<>(current.path);
                    newPath.add(current.name + " -> " + edge.getDirection() + " -> " + edge.getTo());
                    paths.put(edge.getTo(), newPath);

                    queue.add(new Node(edge.getTo(), newDist, newPath));
                }
            }
        }

        return paths;
    }
}


class Node {
    String name;
    int weight;
    List<String> path;

    public Node(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.path = new ArrayList<>();
    }

    public Node(String name, int weight, List<String> path) {
        this.name = name;
        this.weight = weight;
        this.path = new ArrayList<>(path);
    }
}