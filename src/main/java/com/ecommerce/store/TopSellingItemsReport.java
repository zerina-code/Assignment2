package com.ecommerce.store;
import java.util.*;

public class TopSellingItemsReport implements Runnable {
    private List<Purchase> purchases;

    public TopSellingItemsReport(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public void run() {
        Map<String, Integer> sales = new HashMap<>();

        for (Purchase purchase : purchases) {
            String itemName = purchase.getItem().getName();
            sales.put(itemName, sales.getOrDefault(itemName, 0) + purchase.getQuantity());
        }

        sales.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void generate() {
        Thread thread = new Thread(this);
        thread.start();
    }
}




