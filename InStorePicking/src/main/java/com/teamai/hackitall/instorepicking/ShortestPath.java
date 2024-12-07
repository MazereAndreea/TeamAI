package com.teamai.hackitall.instorepicking;

import java.util.*;

public class ShortestPath {


    static class Edge {
        int source, destination, weight;
        String direction;
        public Edge(int source, int destination, int weight, String direction) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.direction = direction;
        }
    }


    public static List<String> dijkstraWithDirections(List<Edge>[] graph, int start, int target) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        int[] previous = new int[n];
        String[] directionToNode = new String[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == target) {
                return reconstructPathWithDirections(previous, directionToNode, target);
            }

            for (Edge edge : graph[node]) {
                if (!visited[edge.destination] && dist + edge.weight < distances[edge.destination]) {
                    distances[edge.destination] = dist + edge.weight;
                    previous[edge.destination] = node;
                    directionToNode[edge.destination] = edge.direction;
                    pq.offer(new int[] { edge.destination, distances[edge.destination] });
                }
            }
        }

        return null;
    }

    private static List<String> reconstructPathWithDirections(int[] previous, String[] directionToNode, int target) {
        List<String> pathWithDirections = new ArrayList<>();
        int current = target;

        while (current != -1) {
            String direction = directionToNode[current];
            pathWithDirections.add((direction != null ? direction : "") + " to Shelf " + current);
            current = previous[current];
        }

        Collections.reverse(pathWithDirections);
        return pathWithDirections;
    }

    public static void main(String[] args) {
        /
        int n = 5;
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        graph[0].add(new Edge(0, 1, 2, "straight"));
        graph[1].add(new Edge(1, 0, 2, "back"));

        graph[0].add(new Edge(0, 2, 4, "right"));
        graph[2].add(new Edge(2, 0, 4, "left"));

        graph[1].add(new Edge(1, 2, 1, "left"));
        graph[2].add(new Edge(2, 1, 1, "right"));

        graph[1].add(new Edge(1, 3, 7, "straight"));
        graph[3].add(new Edge(3, 1, 7, "back"));

        graph[2].add(new Edge(2, 3, 3, "straight"));
        graph[3].add(new Edge(3, 2, 3, "back"));

        graph[3].add(new Edge(3, 4, 2, "straight"));
        graph[4].add(new Edge(4, 3, 2, "back"));


        int start = 0;
        int target = 4;
        List<String> pathWithDirections = dijkstraWithDirections(graph, start, target);

        if (pathWithDirections != null) {
            for (String step : pathWithDirections) {
                System.out.println(step);
            }
        } else {
            System.out.println("Nodul " + target + " este inaccesibil din nodul " + start);
        }
    }
}
