package edu.hw3;

import java.util.PriorityQueue;

public final class Task6 implements StockMarket {

    private final PriorityQueue<Stock> stocks;

    public Task6() {
        stocks = new PriorityQueue<>(Stock::compareTo);
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
