package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @DisplayName("Сломанная строка")
    @ParameterizedTest
    @CsvSource({
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde",
        "ba, ab",
        "b, b"
    })
    void fixString(String str, String expected) {
        assertThat(Task4.fixString(str)).isEqualTo(expected);
    }

}
