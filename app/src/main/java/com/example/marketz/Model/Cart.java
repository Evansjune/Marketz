package com.example.marketz.Model;

public class Cart {
    private String price, name, quantity;

    public Cart() {
    }

    public Cart(String price, String name, String quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
