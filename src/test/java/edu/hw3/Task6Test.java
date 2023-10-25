package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Биржа")
public class Task6Test {
    @Test
    public void testAddStock() {
        Stock stock1 = new Stock("AAPL", 100);
        Task6 exchange1 = new Task6();
        exchange1.add(stock1);
        assertEquals(stock1, exchange1.mostValuableStock());
    }

    @Test
    public void testRemoveStock() {
        Stock stock1 = new Stock("AAPL", 100);
        Task6 exchange1 = new Task6();
        exchange1.add(stock1);
        exchange1.remove(stock1);
        assertNull(exchange1.mostValuableStock());
    }

    @Test
    public void testMostValuableStock() {
        Stock stock2 = new Stock("GOOG", 200);
        Stock stock3 = new Stock("MSFT", 150);
        Task6 exchange2 = new Task6();
        exchange2.add(stock2);
        exchange2.add(stock3);
        assertEquals(stock2, exchange2.mostValuableStock());
    }

    @Test
    public void testNullMostValuableStock() {
        Task6 exchange3 = new Task6();
        assertNull(exchange3.mostValuableStock());
    }

}
