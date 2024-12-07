package com.teamai.hackitall.instorepicking;

import java.util.*;

public class Angajat{
    public static void dijkstra(Raioane raioane, int source) {
        int V = raioane.V;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        Set<Integer> settled = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            if (settled.contains(u)) continue;
            settled.add(u);

            for (Edge neighbor : raioane.adjList.get(u)) {
                int v = neighbor.dest;
                int weight = neighbor.weight;
                if (!settled.contains(v) && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }


        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Raioane {
        public int V;
        ArrayList<ArrayList<Edge>> adjList;

         Raioane(int V) {
            this.V = V;
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Edge(src, dest, weight));
            adjList.get(dest).add(new Edge(dest, src, weight)); // For undirected Raioane
        }

    }
}