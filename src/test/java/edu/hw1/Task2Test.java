package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @DisplayName("Количество цифр в числе")
    @ParameterizedTest
    @CsvSource({
        "32984, 5",
        "4666, 4",
        "544, 3",
        "-1, 1",
        "0, 1"
    })
    void countDigits(int n, int expected) {
        assertThat(Task2.countDigits(n)).isEqualTo(expected);
    }

}
