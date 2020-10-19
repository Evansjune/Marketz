package com.example.marketz.Model;

public class Products {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String image;

    public Products() {
    }

    public Products(String productName, String productDescription, String productPrice, String image) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
