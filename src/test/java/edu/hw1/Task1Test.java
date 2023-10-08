package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @DisplayName("Время видео в секундах")
    @ParameterizedTest
    @CsvSource({
        "01:00, 60",
        "13:56, 836",
        "10:60, -1",
        "-10:03, -1",
        "10:-03, -1",
        "999:01, 59941",
        "01, -1"
    })
    void videoLengths(String time, int totalExpected) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(totalExpected);
    }

}
