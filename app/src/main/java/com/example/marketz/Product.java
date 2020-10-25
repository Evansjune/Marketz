package com.example.marketz;

public class Product {
    private String description;
    private double price;
    private int image;

    public Product(String description, double price, int image) {
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
