package com.ecommerce.store;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CategorySalesReport implements Runnable {
    private List<Purchase> purchases;

    public CategorySalesReport(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public void run() {
        Map<String, Integer> categorySales = new HashMap<>();

        for (Purchase purchase : purchases) {
            Item item = purchase.getItem();
            String category = item.getCategory();
            int quantitySold = purchase.getQuantity();

            categorySales.put(category, categorySales.getOrDefault(category, 0) + quantitySold);
        }

        System.out.println("Category Sales Report:");
        categorySales.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println("Category: " + entry.getKey() + ", Total Quantity Sold: " + entry.getValue()));
    }

    public void generate() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
