package edu.hw3;

import org.jetbrains.annotations.NotNull;

public record Stock(String name, double price) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        return (int) (o.price - this.price);
    }
}
