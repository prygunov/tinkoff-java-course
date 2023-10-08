package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task5Test {

    @ParameterizedTest
    @ValueSource(longs = {11211230, 13001120, 23336014, 11})
    void checkPalindrome(long value) {
        Assertions.assertTrue(Task5.isPalindromeDescendant(value));
    }

    @ParameterizedTest
    @ValueSource(longs = {11211231, 1301120, 23336019})
    void checkNotPalindrome(long value) {
        Assertions.assertFalse(Task5.isPalindromeDescendant(value));
    }

    @ParameterizedTest
    @ValueSource(longs = {9, 1})
    void checkThrows(long value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task5.isPalindromeDescendant(value));
    }
}
