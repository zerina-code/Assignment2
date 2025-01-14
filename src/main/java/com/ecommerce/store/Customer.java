package com.ecommerce.store;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Purchase> purchases;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchases = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public float getTotalSpent() {
        float totalSpent = 0;
        for (Purchase purchase : purchases) {
            totalSpent += purchase.calculatePurchaseTotal();
        }
        return totalSpent;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}



