package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }

    @ParameterizedTest
    @CsvSource({
        "20, 400",
        "21, 441",
        "1, 1",
    })
    void squareArea(int side, int expected) {
        Square square = new Square();
        square.setSide(side);

        assertThat(square.area()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({
        "-1",
        "0",
    })
    void negativeSquareSideTest(int side) {
        Square square = new Square();
        Assertions.assertThrows(IllegalArgumentException.class, () -> square.setSide(side));
    }

    @ParameterizedTest
    @CsvSource({
        "-1",
        "0",
    })
    void negativeRectangleWidthTest(int side) {
        Rectangle rectangle = new Rectangle();
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setWidth(side));
    }

    @ParameterizedTest
    @CsvSource({
        "-1",
        "0",
    })
    void negativeRectangleHeightTest(int side) {
        Rectangle rectangle = new Rectangle();
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setHeight(side));
    }

}
