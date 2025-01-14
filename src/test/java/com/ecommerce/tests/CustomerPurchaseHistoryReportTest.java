package com.ecommerce.tests;
import com.ecommerce.store.Customer;
import com.ecommerce.store.Item;
import com.ecommerce.store.Purchase;
import com.ecommerce.store.CustomerPurchaseHistoryReport;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerPurchaseHistoryReportTest {

    @Test
    void testCustomerPurchaseHistoryReport() {
        Item item = new Item("Laptop", 1200.0f, 10, "electronics");

        Customer customer = new Customer("Alice", "alice@example.com");

        customer.addPurchase(new Purchase(item, 2));

        CustomerPurchaseHistoryReport report = new CustomerPurchaseHistoryReport(customer);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Thread reportThread = new Thread(report);
        reportThread.start();
        try {
            reportThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.setOut(System.out);

        String output = outputStream.toString();

        assertTrue(output.contains("Purchase History for Alice"));
        assertTrue(output.contains("Laptop - Quantity: 2 - Total: $2400.00"));
    }
}


