package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class Task1Test {

    @Test
    void testFromScratch(){
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        Assertions.assertEquals(37, res.evaluate());
    }

    @ParameterizedTest
    @CsvSource({
        "32984, 5, 32989",
        "4666, -4, 4662",
        "544, -544, 0",
    })
    void testAddition(double n1, double n2, double expected) {
        var firstArg = new Constant(n1);
        var secondArg = new Constant(n2);

        Assertions.assertEquals(expected, new Addition(firstArg, secondArg).evaluate());
    }

    @ParameterizedTest
    @CsvSource({
        "32984, 5, 32979",
        "4666, -4, 4670",
        "544, -544, 1088",
    })
    void testNegate(double n1, double n2, double expected) {
        var firstArg = new Constant(n1);
        var secondArg = new Negate(n2);

        Assertions.assertEquals(expected, new Addition(firstArg, secondArg).evaluate());
    }

    @ParameterizedTest
    @CsvSource({
        "10, 5, 50",
        "40, -4, -160",
        "-10, -35, 350",
        "-10, -0.1, 1",
    })
    void testMultiplication(double n1, double n2, double expected) {
        var firstArg = new Constant(n1);
        var secondArg = new Constant(n2);

        Assertions.assertEquals(expected, new Multiplication(firstArg, secondArg).evaluate());
    }

}
