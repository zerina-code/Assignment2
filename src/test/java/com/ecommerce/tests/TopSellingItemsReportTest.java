package com.ecommerce.tests;
import com.ecommerce.store.Item;
import com.ecommerce.store.Purchase;
import com.ecommerce.store.TopSellingItemsReport;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopSellingItemsReportTest {

    @Test
    void testTopSellingItemsReport() {
        Item laptop = new Item("Laptop", 1200.0f, 10, "electronics");
        Item smartphone = new Item("Smartphone", 800.0f, 5, "electronics");

        Purchase purchase1 = new Purchase(laptop, 3);
        Purchase purchase2 = new Purchase(smartphone, 5);

        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalSystemOut = System.out;

        System.setOut(printStream);

        new TopSellingItemsReport(purchases).run();

        System.setOut(originalSystemOut);

        String output = outputStream.toString();

        assertTrue(output.contains("Laptop: 3"));
        assertTrue(output.contains("Smartphone: 5"));
    }
}

