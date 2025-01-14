package com.ecommerce.tests;
import com.ecommerce.store.Customer;
import com.ecommerce.store.Purchase;
import com.ecommerce.store.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    @Test
    void testCustomerConstructorAndGetters() {
        Customer customer = new Customer("Alice", "alice@example.com");

        assertEquals("Alice", customer.getName());
        assertEquals("alice@example.com", customer.getEmail());
    }

    @Test
    void testAddPurchase() {
        Item item = new Item("Laptop", 1200.0f, 10, "electronics");
        Customer customer = new Customer("Alice", "alice@example.com");

        Purchase purchase = new Purchase(item, 2);
        customer.addPurchase(purchase);

        assertEquals(1, customer.getPurchases().size());
        assertEquals(item, customer.getPurchases().get(0).getItem());
        assertEquals(2, customer.getPurchases().get(0).getQuantity());
    }

    @Test
    void testGetTotalSpent() {
        Item item = new Item("Laptop", 1200.0f, 10, "electronics");
        Customer customer = new Customer("Alice", "alice@example.com");

        customer.addPurchase(new Purchase(item, 2));

        assertEquals(2400.0f, customer.getTotalSpent(), 0.01f);
    }
    @Test
    void testGetTotalSpentWhenNoPurchases() {
        Customer customer = new Customer("Alice", "alice@example.com");
        assertEquals(0.0f, customer.getTotalSpent(), 0.01f);
    }

}

