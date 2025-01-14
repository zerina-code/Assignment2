package com.ecommerce.store;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Item> items = loadItems("items.csv");
        Map<String, Customer> customers = loadCustomers("customers.csv");
        List<Purchase> purchases = loadPurchases("purchases.csv", items, customers);

        List<Item> itemList = new ArrayList<>(items.values());
        List<Customer> customerList = new ArrayList<>(customers.values());

        TopSellingItemsReport report1 = new TopSellingItemsReport(purchases);
        Thread reportThread1 = new Thread(report1);
        reportThread1.start();
        reportThread1.join();


        TopCustomersReport report2 = new TopCustomersReport(customerList);
        Thread reportThread2 = new Thread(report2);
        reportThread2.start();
        reportThread2.join();


        CategorySalesReport report3 = new CategorySalesReport(purchases);
        Thread reportThread3 = new Thread(report3);
        reportThread3.start();
        reportThread3.join();


        CustomerPurchaseHistoryReport report4 = new CustomerPurchaseHistoryReport(customers.get("Alice Smith"));
        Thread reportThread4 = new Thread(report4);
        reportThread4.start();
        reportThread4.join();


        InventoryReport report5 = new InventoryReport(itemList);
        Thread reportThread5 = new Thread(report5);
        reportThread5.start();
        reportThread5.join();
    }

    private static Map<String, Item> loadItems(String filePath) throws IOException {
        Map<String, Item> items = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                float price = Float.parseFloat(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                String category = parts[3];
                items.put(name, new Item(name, price, quantity, category));
            }
        }
        return items;
    }

    private static Map<String, Customer> loadCustomers(String filePath) throws IOException {
        Map<String, Customer> customers = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                String email = parts[1];
                customers.put(name, new Customer(name, email));
            }
        }
        return customers;
    }

    private static List<Purchase> loadPurchases(String filePath, Map<String, Item> items, Map<String, Customer> customers) throws IOException {
        List<Purchase> purchases = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String customerName = parts[0];
                String itemName = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                Item item = items.get(itemName);
                Customer customer = customers.get(customerName);
                Purchase purchase = new Purchase(item, quantity);

                purchases.add(purchase);
                customer.addPurchase(purchase);
                item.reduceQuantity(quantity);
            }
        }
        return purchases;
    }
}

