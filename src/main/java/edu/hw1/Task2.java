package edu.hw1;

public final class Task2 {

    public static final int NUMBER_BASE = 10;

    private Task2() {
    }

    public static long countDigits(long number) {
        long digits = 0;
        long source = number;
        do {
            digits++;
            source /= NUMBER_BASE;
        } while (source != 0);
        return digits;
    }
}
