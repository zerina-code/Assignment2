package com.ecommerce.tests;
import com.ecommerce.store.CategorySalesReport;
import com.ecommerce.store.Item;
import com.ecommerce.store.Purchase;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategorySalesReportTest {

    @Test
    public void testCategorySalesReport() throws InterruptedException {
        Item item1 = new Item("Laptop", 1200.0f, 10, "electronics");
        Item item2 = new Item("Desk", 200.0f, 5, "furniture");

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new Purchase(item1, 2));
        purchases.add(new Purchase(item2, 1));

        CategorySalesReport report = new CategorySalesReport(purchases);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Thread reportThread = new Thread(report);
        reportThread.start();
        reportThread.join();

        String output = outputStream.toString();

        System.out.println(output);

        assertTrue(output.contains("Category: electronics"), "Output should contain category: electronics");
        assertTrue(output.contains("Category: furniture"), "Output should contain category: furniture");
        assertTrue(output.contains("Total Quantity Sold: 2"), "Output should contain sales data for electronics");
        assertTrue(output.contains("Total Quantity Sold: 1"), "Output should contain sales data for furniture");
    }
}


