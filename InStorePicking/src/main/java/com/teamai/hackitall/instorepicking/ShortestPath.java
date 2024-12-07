package com.teamai.hackitall.instorepicking;

import java.util.*;

import java.util.*;

public class ShortestPath {

    // Structură pentru muchii
    static class Edge {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Funcție pentru Dijkstra
    public static int dijkstraToTarget(List<Edge>[] graph, int start, int target) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (visited[node]) continue;
            visited[node] = true;

            // If we've reached the target node, return the distance
            if (node == target) {
                return dist;
            }

            for (Edge edge : graph[node]) {
                if (!visited[edge.destination] && dist + edge.weight < distances[edge.destination]) {
                    distances[edge.destination] = dist + edge.weight;
                    pq.offer(new int[] { edge.destination, distances[edge.destination] });
                }
            }
        }

        // If the target is unreachable
        return -1;
    }

    public static void main(String[] args) {
        // Graful: lista de adiacență
        int n = 5; // număr de noduri
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adaugă muchii
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[1].add(new Edge(1, 3, 7));
        graph[3].add(new Edge(3, 1, 7));

        graph[2].add(new Edge(2, 3, 3));
        graph[3].add(new Edge(3, 2, 3));

        graph[3].add(new Edge(3, 4, 2));
        graph[4].add(new Edge(4, 3, 2));

        // Calculăm drumul minim de la 0 la 4
        int start = 0;
        int target = 4;
        int shortestDistance = dijkstraToTarget(graph, start, target);

        if (shortestDistance != -1) {
            System.out.println("Cel mai scurt drum de la nodul " + start + " la nodul " + target + " este: " + shortestDistance);
        } else {
            System.out.println("Nodul " + target + " este inaccesibil din nodul " + start);
        }
    }
}
