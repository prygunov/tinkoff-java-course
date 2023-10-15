package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Вложенный массив")
public class Task3Test {

    @Test
    void isArrayNestable1() {
        long[] arr1 = {1, 2, 3, 4};
        long[] arr2 = {0, 6};

        boolean result = Task3.isNestable(arr1, arr2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void isArrayNestable2() {
        long[] arr1 = {3, 1};
        long[] arr2 = {4, 0};

        boolean result = Task3.isNestable(arr1, arr2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void isArrayNotNestable1() {
        long[] arr1 = {9, 9, 8};
        long[] arr2 = {8, 9};

        boolean result = Task3.isNestable(arr1, arr2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void isArrayNotNestable2() {
        long[] arr1 = {1, 2, 3, 4};
        long[] arr2 = {2, 3};

        boolean result = Task3.isNestable(arr1, arr2);

        assertThat(result).isEqualTo(false);
    }
}
