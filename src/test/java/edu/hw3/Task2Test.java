package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Кластеризация скобок")
public class Task2Test {

    static Arguments[] args() {
        return new Arguments[] {
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("(()())", List.of("(()())")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        };
    }

    @ParameterizedTest
    @MethodSource("args")
    void testFromScratch(String input, List<String> expectedOutput) {
        assertThat(Task2.clusterize(input)).isEqualTo(expectedOutput);
    }
}
