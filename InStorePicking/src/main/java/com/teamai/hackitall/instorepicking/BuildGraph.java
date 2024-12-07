package com.teamai.hackitall.instorepicking;

class BuildGraph {
    public static Graph buildGraph() {
        Graph store = new Graph();

        int totalRaioane = 6;
        int totalSectoare = 3;

        for (int raion = 1; raion <= totalRaioane; raion++) {
            for (int sector = 1; sector <= totalSectoare; sector++) {
                String nodeName = "Raionul " + raion + "-Sector " + sector;
                store.addNode(nodeName);
            }
        }
        store.addNode("Start");

        store.addEdge("Start", "Raionul 1-Sector 1", 15, "Straight");
        store.addEdge("Start", "Raionul 1-Sector 3", 10, "Right");
        store.addEdge("Start", "Raionul 2-Sector 1", 7, "Left");
        store.addEdge("Start", "Raionul 2-Sector 3", 10, "Straight");
        store.addEdge("Start", "Raionul 3-Sector 1", 14, "Left");
        store.addEdge("Start", "Raionul 3-Sector 3", 19, "Straight");

        for (int raion = 1; raion <= totalRaioane; raion++) {
            for (int sector = 1; sector < totalSectoare; sector++) {
                String from = "Raionul " + raion + "-Sector " + sector;
                String to = "Raionul " + raion + "-Sector " + (sector + 1);

                store.addEdge(from, to, 5, "Straight");
            }
        }

        for (int sector = 1; sector <= totalSectoare; sector++) {
            for (int raion = 1; raion < totalRaioane; raion++) {
                String from = "Raionul " + raion + "-Sector " + sector;
                String to = "Raionul " + (raion + 1) + "-Sector " + sector;

                store.addEdge(from, to, 10, "Left");
            }
        }

        return store;
    }
}