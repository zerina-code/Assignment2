package com.ecommerce.store;
import java.util.*;
import java.util.stream.Collectors;

public class TopCustomersReport implements Runnable {
    private List<Customer> customers;

    public TopCustomersReport(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void run() {

        List<Customer> topCustomers = customers.stream()
                .sorted((customer1, customer2) -> Double.compare(customer2.getTotalSpent(), customer1.getTotalSpent()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top 10 Customers:");
        for (Customer customer : topCustomers) {
            System.out.printf("%s - $%.2f\n", customer.getName(), customer.getTotalSpent());
        }
    }

    public void generate() {
        Thread thread = new Thread(this);
        thread.start();
    }
}


