package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class Task6 {

    public static final int CAPRECARA_NUMBER = 6174;

    private Task6() {
    }

    public static long countK(long number) {
        return countK(number, 1);
    }

    private static long countK(long number, int step) {
        Character[] charArrBoxed = Long.toString(Math.abs(number))
            .chars()
            .mapToObj(c -> (char) c)
            .toArray(Character[]::new);

        Arrays.sort(charArrBoxed);
        int small = charArrayToInteger(charArrBoxed);
        Arrays.sort(charArrBoxed, Comparator.reverseOrder());
        int big = charArrayToInteger(charArrBoxed);

        if (big - small == CAPRECARA_NUMBER) {
            return step;
        } else {
            return countK(big - small, step + 1);
        }
    }

    private static int charArrayToInteger(Character[] array) {
        var string = Arrays.stream(array).map(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(string);
    }

}
