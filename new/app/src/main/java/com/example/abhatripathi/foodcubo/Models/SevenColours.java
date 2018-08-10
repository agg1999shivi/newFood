package com.example.abhatripathi.foodcubo.Models;

public class SevenColours {
    private String Image;
    private String Product;

    public SevenColours(String image, String product) {
        Image = image;
        Product = product;
    }

    public SevenColours() {
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }
}
