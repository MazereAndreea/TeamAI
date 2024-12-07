package com.teamai.hackitall.instorepicking;

class Edge {
    String to;
    int weight;

    public Edge(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public String getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}