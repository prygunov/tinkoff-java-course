package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Циклический битовый сдвиг")
public class Task7Test {

    @ParameterizedTest
    @CsvSource({
        "8, 1, 4",
        "8, 32, 8",
        "8, -1, 1"
    })
    void rotateRight(int n, int shift, int expectedAnswer) {
        assertThat(Task7.rotateRight(n, shift)).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @CsvSource({
        "16, 1, 1",
        "17, 2, 6",
        "17, 10, 17",
        "16, -1, 8"
    })
    void rotateLeft(int n, int shift, int expectedAnswer) {
        assertThat(Task7.rotateLeft(n, shift)).isEqualTo(expectedAnswer);
    }
}
