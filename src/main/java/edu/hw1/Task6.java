package edu.hw1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Task6 {

    public static final int CAPRECARA_NUMBER = 6174;
    public static final int MIN_INPUT = 1001;
    public static final int MAX_INPUT = 9999;
    public static final int NUMBER_SIZE = 4;

    private Task6() {
    }

    public static long countK(long number) {
        if (number < MIN_INPUT || number > MAX_INPUT) {
            throw new IllegalArgumentException("Number must be greater than 1000 and less than 10000");
        }

        return countK(number, 1);
    }

    private static long countK(long number, int step) {
        List<Character> digitsList = Long.toString(number)
            .chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toList());

        while (digitsList.size() < NUMBER_SIZE) {
            digitsList.add('0');
        }

        boolean allMatch = digitsList.stream().allMatch(character -> digitsList.get(0) == character);
        if (allMatch) {
            throw new IllegalArgumentException("All digits must be unique");
        }

        Collections.sort(digitsList);
        int smallNumber = charListToInteger(digitsList);

        digitsList.sort(Comparator.reverseOrder());
        int bigNumber = charListToInteger(digitsList);

        if (bigNumber - smallNumber == CAPRECARA_NUMBER) {
            return step;
        } else {
            return countK(bigNumber - smallNumber, step + 1);
        }
    }

    private static int charListToInteger(List<Character> charList) {
        var string = charList.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());

        return Integer.parseInt(string);
    }

}
