package com.ecommerce.tests;
import com.ecommerce.store.Item;
import com.ecommerce.store.InventoryReport;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryReportTest {

    @Test
    void testInventoryReport() {

        Item item1 = new Item("Laptop", 1200.0f, 10, "electronics");
        Item item2 = new Item("Smartphone", 800.0f, 5, "electronics");

        List<Item> items = Arrays.asList(item1, item2);


        InventoryReport report = new InventoryReport(items);

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

        assertTrue(output.contains("Inventory Report"));
        assertTrue(output.contains("Laptop - Quantity: 10"));
        assertTrue(output.contains("Smartphone - Quantity: 5"));
    }
}

