package com.ecommerce.store;

public class CustomerPurchaseHistoryReport implements Runnable {

    private Customer customer;

    public CustomerPurchaseHistoryReport(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        System.out.println("Purchase History for " + customer.getName() + ":");

        for (Purchase purchase : customer.getPurchases()) {
            Item item = purchase.getItem();
            double totalSpent = item.getPrice() * purchase.getQuantity();
            System.out.printf("%s - Quantity: %d - Total: $%.2f\n", item.getName(), purchase.getQuantity(), totalSpent);
        }
    }

    public void generate() {
        Thread thread = new Thread(this);
        thread.start();
    }
}

