package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Время видео в секундах")
public class Task1Test {

    @ParameterizedTest
    @CsvSource({
        "01:00, 60",
        "13:56, 836",
        "999:01, 59941",
        "10:60, -1",
        "-10:03, -1",
        "10:-03, -1",
        "01, -1",
        "'', -1",
        "abc, -1",
        "abc:0, -1"
    })
    void videoLengths(String time, int totalExpected) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(totalExpected);
    }

}
