package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class Task6 {

    public static final int CAPRECARA_NUMBER = 6174;
    public static final int MIN_INPUT = 1001;
    public static final int MAX_INPUT = 9999;

    private Task6() {
    }

    public static long countK(long number) {
        if (number < MIN_INPUT || number > MAX_INPUT) {
            throw new IllegalArgumentException("Number must be greater than 1000 and less than 10000");
        }

        return countK(number, 1);
    }

    private static long countK(long number, int step) {
        Character[] digitsArr = Long.toString(Math.abs(number))
            .chars()
            .mapToObj(c -> (char) c)
            .toArray(Character[]::new);

        boolean allMatch = Arrays.stream(digitsArr).allMatch(character -> digitsArr[0] == character);
        if (allMatch) {
            throw new IllegalArgumentException("All digits must be unique");
        }

        Arrays.sort(digitsArr);
        int smallNumber = charArrayToInteger(digitsArr);

        Arrays.sort(digitsArr, Comparator.reverseOrder());
        int bigNumber = charArrayToInteger(digitsArr);

        if (bigNumber - smallNumber == CAPRECARA_NUMBER) {
            return step;
        } else {
            return countK(bigNumber - smallNumber, step + 1);
        }
    }

    private static int charArrayToInteger(Character[] array) {
        var string = Arrays.stream(array)
            .map(String::valueOf)
            .collect(Collectors.joining());

        return Integer.parseInt(string);
    }

}
