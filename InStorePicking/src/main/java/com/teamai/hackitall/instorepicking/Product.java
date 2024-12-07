package com.teamai.hackitall.instorepicking;

public class Product {
    private int id;
    private String name;
    private String position; // Can be "left", "middle", "right"

    public Product(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}