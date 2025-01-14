package com.ecommerce.tests;
import com.ecommerce.store.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Laptop", 1500.0f, 10, "Electronics");
    }

    @Test
    void testConstructor() {
        assertEquals("Laptop", item.getName());
        assertEquals(1500.0f, item.getPrice());
        assertEquals(10, item.getQuantity());
        assertEquals("Electronics", item.getCategory());
    }

    @Test
    void testSettersAndGetters() {
        item.setName("Smartphone");
        item.setPrice(1200.0f);
        item.setQuantity(20);
        item.setCategory("Mobiles");

        assertEquals("Smartphone", item.getName());
        assertEquals(1200.0f, item.getPrice());
        assertEquals(20, item.getQuantity());
        assertEquals("Mobiles", item.getCategory());
    }

    @Test
    void testReduceQuantity() {
        item.reduceQuantity(3);
        assertEquals(7, item.getQuantity());

        item.reduceQuantity(10);
        assertEquals(0, item.getQuantity());
    }

    @Test
    void testReduceQuantityWhenNegative() {
        item.reduceQuantity(15);
        assertEquals(0, item.getQuantity());
    }
}

