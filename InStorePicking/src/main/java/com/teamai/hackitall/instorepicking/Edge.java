package com.teamai.hackitall.instorepicking;

class Edge {
    String to;
    int weight;
    String direction;

    public Edge(String to, int weight, String direction) {
        this.to = to;
        this.weight = weight;
        this.direction = direction;
    }

    public String getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public String getDirection() {
        return direction;
    }
}