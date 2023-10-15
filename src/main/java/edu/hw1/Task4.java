package edu.hw1;

import java.util.Objects;

public final class Task4 {

    private Task4() {
    }

    public static String fixString(String s) {
        Objects.requireNonNull(s);

        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length() - 1; i += 2) {
            char temp = stringBuilder.charAt(i);

            int nextCharIndex = i + 1;

            stringBuilder.setCharAt(i, stringBuilder.charAt(nextCharIndex));
            stringBuilder.setCharAt(nextCharIndex, temp);
        }
        return stringBuilder.toString();
    }
}
