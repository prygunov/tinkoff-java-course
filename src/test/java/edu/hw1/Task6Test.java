package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Постоянная Капрекара")
public class Task6Test {

    @ParameterizedTest
    @CsvSource({
        "3524, 3",
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "2221, 5"
    })
    void countStepsToCaprecara(int number, int expectedSteps) {
        assertThat(Task6.countK(number)).isEqualTo(expectedSteps);
    }

    @ParameterizedTest
    @ValueSource(ints = {3333, -10})
    void checkBadInput(int number) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task6.countK(number));
    }
}
