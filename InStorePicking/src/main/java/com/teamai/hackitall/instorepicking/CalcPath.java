package com.teamai.hackitall.instorepicking;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CalcPath {
    public static void optimizePickOrder(Graph storeGraph, List<String> pickList, String start) {
        Map<String, List<String>> paths = InstorePicker.shortestPath(storeGraph, start);

        for (String pick : pickList) {
            System.out.println("Path to " + pick + ": " + paths.get(pick));
        }
    }

    CalcPath() {
        Graph store = BuildGraph.buildGraph();

        List<String> pickList = Arrays.asList(
        "Raionul 3-Sector 3",
        "Raionul 1-Sector 1",
        "Raionul 2-Sector 3",
        "Raionul 6-Sector 3"
    );

        optimizePickOrder(store, pickList, "Raionul 3-Sector 3");
    }
}