package com.ecommerce.tests;
import com.ecommerce.store.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopCustomersReportTest {

    @Test
    public void testTopCustomersReportSortedDescendingByAmountSpent() {
        Item item1 = new Item("Laptop", 1000.00f, 10, "Electronics");
        Item item2 = new Item("Smartphone", 500.00f, 20, "Electronics");

        Customer customer1 = new Customer("Alice", "alice@example.com");
        Customer customer2 = new Customer("Bob", "bob@example.com");

        customer1.addPurchase(new Purchase(item1, 1));
        customer1.addPurchase(new Purchase(item2, 2));

        customer2.addPurchase(new Purchase(item2, 3));

        List<Customer> customers = Arrays.asList(customer1, customer2);

        TopCustomersReport report = new TopCustomersReport(customers);
        report.run();

        float bobTotalSpent = customer2.getTotalSpent();
        System.out.println("Bob's total spent: " + bobTotalSpent);
        assertTrue(bobTotalSpent == 1500.0f, "Bob's spending should be 1500.0");

        float aliceTotalSpent = customer1.getTotalSpent();
        System.out.println("Alice's total spent: " + aliceTotalSpent);
        assertTrue(aliceTotalSpent == 2000.0f, "Alice's spending should be 2000.0");


    }
}


