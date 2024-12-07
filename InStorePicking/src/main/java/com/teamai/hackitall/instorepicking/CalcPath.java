package com.teamai.hackitall.instorepicking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CalcPath {
    private static List<String> optimizedOrder; // Make it a static field

    public static List<String> optimizePickOrder(Graph storeGraph, List<String> pickList, String start) {
        Map<String, Integer> distances = InstorePicker.shortestPath(storeGraph, start);

        pickList.sort(Comparator.comparingInt(distances::get));

        return pickList;
    }

    public CalcPath() {
        Graph store = new Graph();
        store.addNode("Start");
        store.addNode("Raionul 1-Sector 1");
        store.addNode("Raionul 1-Sector 2");
        store.addNode("Raionul 1-Sector 3");
        store.addNode("Raionul 1-Sector 4");
        store.addNode("Raionul 2-Sector 5");
        store.addNode("Raionul 2-Sector 6");
        store.addNode("Raionul 2-Sector 7");
        store.addNode("Raionul 2-Sector 8");
        store.addNode("Raionul 3-Sector 9");
        store.addNode("Raionul 3-Sector 10");
        store.addNode("Raionul 3-Sector 11");
        store.addNode("Raionul 3-Sector 12");
        store.addNode("Raionul 4-Sector 13");
        store.addNode("Raionul 4-Sector 14");
        store.addNode("Raionul 4-Sector 15");
        store.addNode("Raionul 5-Sector 16");
        store.addNode("Raionul 5-Sector 17");
        store.addNode("Raionul 5-Sector 18");
        store.addNode("Raionul 5-Sector 19");
        store.addNode("Raionul 6-Sector 20");
        store.addNode("Raionul 6-Sector 21");
        store.addNode("Raionul 6-Sector 22");
        store.addNode("Raionul 6-Sector 23");

        store.addEdge("Start", "Raionul 1-Sector 1", 15);
        store.addEdge("Start", "Raionul 1-Sector 4", 10);
        store.addEdge("Start", "Raionul 2-Sector 5", 7);
        store.addEdge("Start", "Raionul 2-Sector 8", 10);
        store.addEdge("Start", "Raionul 3-Sector 9", 14);
        store.addEdge("Start", "Raionul 3-Sector 12", 19);

        List<String> pickList = Arrays.asList("Raionul 3-Sector 9", "Raionul 1-Sector 1", "Raionul 2-Sector 5");

        optimizedOrder = optimizePickOrder(store, pickList, "Start");
        System.out.println("Optimized Pick Order: " + optimizedOrder);
    }

    // Expose the optimized list
    public static List<String> getOptimizedOrder() {
        return optimizedOrder;
    }
}
