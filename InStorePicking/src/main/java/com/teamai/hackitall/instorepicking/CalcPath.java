package com.teamai.hackitall.instorepicking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CalcPath {
    public static List<String> optimizePickOrder(Graph storeGraph, List<String> pickList, String start) {
        Map<String, Integer> distances = InstorePicker.shortestPath(storeGraph, start);

        pickList.sort(Comparator.comparingInt(distances::get));

        return pickList;
    }

    CalcPath() {
        Graph store = new Graph();
        store.addNode("Start");
        store.addNode("Raionul 1-Sector 1");
        store.addNode("Raionul 1-Sector 2");
        store.addNode("Raionul 1-Sector 3");
        store.addNode("Raionul 2-Sector 1");
        store.addNode("Raionul 2-Sector 2");
        store.addNode("Raionul 2-Sector 3");
        store.addNode("Raionul 3-Sector 1");
        store.addNode("Raionul 3-Sector 2");
        store.addNode("Raionul 3-Sector 3");
        store.addNode("Raionul 4-Sector 1");
        store.addNode("Raionul 4-Sector 2");
        store.addNode("Raionul 5-Sector 1");
        store.addNode("Raionul 5-Sector 2");
        store.addNode("Raionul 5-Sector 3");
        store.addNode("Raionul 6-Sector 1");
        store.addNode("Raionul 6-Sector 2");
        store.addNode("Raionul 6-Sector 3");

        store.addEdge("Start", "Raionul 1-Sector 1", 15);
        store.addEdge("Start", "Raionul 1-Sector 3", 10);
        store.addEdge("Start", "Raionul 2-Sector 1", 7);
        store.addEdge("Start", "Raionul 2-Sector 3", 10);
        store.addEdge("Start", "Raionul 3-Sector 1", 14);
        store.addEdge("Start", "Raionul 3-Sector 3", 19);

        List<String> pickList = Arrays.asList("Raionul 3-Sector 3", "Raionul 1-Sector 1", "Raionul 2-Sector 3");

        List<String> optimizedOrder = optimizePickOrder(store, pickList, "Start");
        System.out.println("Optimized Pick Order: " + optimizedOrder);
    }


}