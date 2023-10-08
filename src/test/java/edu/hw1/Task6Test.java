package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @ParameterizedTest
    @CsvSource({
        "3524, 3",
        "6621, 5",
        "6554, 4",
        "1234, 3"
    })
    void countK(int number, int expectedSteps) {
        assertThat(Task6.countK(number)).isEqualTo(expectedSteps);
    }
}
