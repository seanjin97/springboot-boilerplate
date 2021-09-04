package com.group8.models;

import java.io.Serializable;

// DTO = Data Transfer Object. It is an intermediate object that's used to
// hold data temporarily e.g. PUT/ POST request bodies without certain fields like ID.
public class ProductDTO implements Serializable {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public ProductDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
