package com.ecommerce.store;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryReport implements Runnable {

    private List<Item> items;

    public InventoryReport(List<Item> items) {
        this.items = items;
    }

    @Override
    public void run() {
        List<Item> sortedItems = items.stream()
                .sorted((item1, item2) -> Integer.compare(item2.getQuantity(), item1.getQuantity()))
                .collect(Collectors.toList());

        System.out.println("Inventory Report:");
        for (Item item : sortedItems) {
            System.out.printf("%s - Quantity: %d\n", item.getName(), item.getQuantity());
        }
    }

    public void generate() {
        Thread thread = new Thread(this);
        thread.start();
    }
}
