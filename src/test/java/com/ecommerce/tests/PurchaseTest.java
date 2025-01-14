package com.ecommerce.tests;
import com.ecommerce.store.Purchase;
import com.ecommerce.store.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void testPurchaseConstructorAndGetters() {
        Item item = new Item("Laptop", 1200.0f, 10, "electronics");
        Purchase purchase = new Purchase(item, 2);

        assertEquals(item, purchase.getItem());
        assertEquals(2, purchase.getQuantity());
    }

    @Test
    void testSetters() {
        Item item = new Item("Laptop", 1200.0f, 10, "electronics");
        Purchase purchase = new Purchase(item, 2);

        Item newItem = new Item("Smartphone", 800.0f, 5, "electronics");
        purchase.setItem(newItem);
        purchase.setQuantity(3);

        assertEquals(newItem, purchase.getItem());
        assertEquals(3, purchase.getQuantity());
    }
}
