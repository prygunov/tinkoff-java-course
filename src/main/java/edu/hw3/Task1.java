package edu.hw3;

import java.util.Objects;

public final class Task1 {

    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final static int ALPHABET_SIZE = ALPHABET.length();

    private Task1() {
    }

    public static String atbash(String input) {
        Objects.requireNonNull(input);

        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean isUpper = Character.isUpperCase(arr[i]);
            char temp = Character.toLowerCase(arr[i]);

            if (ALPHABET.indexOf(temp) == -1) {
                continue;
            }

            arr[i] = ALPHABET.charAt(ALPHABET_SIZE - ALPHABET.indexOf(temp) - 1);
            arr[i] = isUpper ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
        }
        return new String(arr);
    }
}
