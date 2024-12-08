package com.teamai.hackitall.instorepicking;

import javafx.fxml.FXML;

import java.util.*;

import static com.teamai.hackitall.instorepicking.Categorie.*;

public class ShortestPath {
    public String textArea = "";
    public int stepsText;
    private List<Edge>[] graph;
    private ArrayList<Integer> targets = new ArrayList<>(Arrays.asList(3,2,6,4));
    private int nrProduse;

    static class Edge {
        int source, destination, weight ;
        String direction;
        public Edge(int source, int destination, int weight, String direction) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.direction = direction;
        }
    }

    public static List<String> dijkstraWithDirections(List<Edge>[] graph, int start, int target, ArrayList<Integer> targets) {
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
            pathWithDirections.add((direction != null ? direction : "") + " Raftul curent: " + current);
            current = previous[current];
        }

        Collections.reverse(pathWithDirections);
        return pathWithDirections;
    }

    ShortestPath() {
        ConstructPath();
        calcNextProduct();
    }

    public void ConstructPath() {
        int n = 7;
        graph = new ArrayList[n];
        nrProduse = targets.size();
        target = targets.getFirst();

        Collections.sort(targets);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[Categorie.LACTATE.ordinal()].add(new Edge(0, 1, 2, "straight"));
        graph[Categorie.CARNURI.ordinal()].add(new Edge(1, 0, 2, "back"));

        graph[Categorie.LACTATE.ordinal()].add(new Edge(0, 2, 4, "right"));
        graph[Categorie.CARTOFI.ordinal()].add(new Edge(2, 0, 4, "left"));

        graph[Categorie.CARNURI.ordinal()].add(new Edge(1, 2, 1, "left"));
        graph[Categorie.CARTOFI.ordinal()].add(new Edge(2, 1, 1, "right"));

        graph[Categorie.CARNURI.ordinal()].add(new Edge(1, 3, 7, "straight"));
        graph[Categorie.DULCIURI.ordinal()].add(new Edge(3, 1, 7, "back"));

        graph[Categorie.CARTOFI.ordinal()].add(new Edge(2, 3, 3, "diagonal-stanga"));
        graph[Categorie.DULCIURI.ordinal()].add(new Edge(3, 2, 3, "diagonal-stanga-back"));

        graph[Categorie.DULCIURI.ordinal()].add(new Edge(3, 4, 2, "straight"));
        graph[Categorie.LEGUME.ordinal()].add(new Edge(4, 3, 2, "back"));

        graph[Categorie.CARNURI.ordinal()].add(new Edge(2, 5, 2, "right"));
        graph[Categorie.CONGELATE.ordinal()].add(new Edge(5, 2, 2, "left"));

        graph[Categorie.DULCIURI.ordinal()].add(new Edge(3, 6, 10, "right"));
        graph[Categorie.PANIFICATIE.ordinal()].add(new Edge(6, 3, 10, "left"));

        graph[Categorie.CARTOFI.ordinal()].add(new Edge(2, 6, 10, "straight"));
        graph[Categorie.PANIFICATIE.ordinal()].add(new Edge(6, 2, 10, "back"));

        graph[Categorie.CARNURI.ordinal()].add(new Edge(1, 6, 10, "diagonal-dreapta"));
        graph[Categorie.PANIFICATIE.ordinal()].add(new Edge(6, 1, 10, "left"));

        graph[Categorie.CONGELATE.ordinal()].add(new Edge(5, 6, 4, "diagonal-stanga"));
        graph[Categorie.PANIFICATIE.ordinal()].add(new Edge(6, 5, 4, "back-diagonal-stanga"));

        graph[Categorie.LEGUME.ordinal()].add(new Edge(4, 6, 10, "diagonal-stanga"));
        graph[Categorie.PANIFICATIE.ordinal()].add(new Edge(6, 4,10 , "back-diagonal-stanga"));
    }

    private int start = 0;
    private int iterator = 1;
    int target;

    public boolean calcNextProduct() {
        if(iterator <= nrProduse){
            List<String> pathWithDirections = dijkstraWithDirections(graph, start, target, targets);
            if (pathWithDirections != null) {
                textArea = "";

                for (String step : pathWithDirections) {
                    textArea += step + "\n";
                    System.out.println(step);
                }
            } else {
                System.out.println("Node " + target + " is inaccessible from node " + start);
            }
            
            stepsText = start;
            start = target;
            if(++iterator > targets.size() -1)
                return false;

            target = targets.get(iterator);
            System.out.println(" ");
            System.out.println("PRODUS NOU");
        }

        return true;
    }
}