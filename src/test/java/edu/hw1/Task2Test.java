package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Количество цифр в числе")
public class Task2Test {

    @ParameterizedTest
    @CsvSource({
        "32984, 5",
        "4666, 4",
        "544, 3",
        "-544, 3",
        "-500, 3",
        "-1, 1",
        "0, 1"
    })
    void countDigits(int n, int expected) {
        assertThat(Task2.countDigits(n)).isEqualTo(expected);
    }

}
