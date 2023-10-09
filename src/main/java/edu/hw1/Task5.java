package edu.hw1;

public final class Task5 {

    public static final int DIGIT_RADIX = 10;

    private Task5() {
    }

    public static boolean isPalindromeDescendant(long number) {
        StringBuilder builder = new StringBuilder(Long.toString(Math.abs(number)));
        if (builder.length() < 2) {
            throw new IllegalArgumentException("Number must have at least 2 digits");
        }

        if (isPalindrome(builder)) {
            return true;
        }

        builder = getChild(builder);
        do {
            if (isPalindrome(builder)) {
                return true;
            }
            builder = getChild(builder);
        } while (builder.length() > 1);

        return false;
    }

    private static StringBuilder getChild(StringBuilder oldBuilder) {
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 1; i < oldBuilder.length(); i += 2) {
            int n1 = Character.digit(oldBuilder.charAt(i - 1), DIGIT_RADIX);
            int n2 = Character.digit(oldBuilder.charAt(i), DIGIT_RADIX);
            builder.append(n1 + n2);
        }
        if (i == oldBuilder.length()) {
            // last char fix
            builder.append(Character.digit(oldBuilder.charAt(i - 1), DIGIT_RADIX));
        }
        return builder;
    }

    private static boolean isPalindrome(StringBuilder s) {
        return s != null && (new StringBuilder(s).reverse().compareTo(s) == 0);
    }
}
