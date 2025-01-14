package com.ecommerce.store;

public class Item {
    private String name;
    private float price;
    private int quantity;
    private String category;

    public Item(String name, float price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void reduceQuantity(int quantityPurchased) {
        this.quantity -= quantityPurchased;
        if (this.quantity < 0) {
            this.quantity = 0;
        }
    }

    public float calculateTotalPrice(int purchasedQuantity) {
        return this.price * purchasedQuantity;
    }
}

