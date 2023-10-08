package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Кони на доске")
public class Task8Test {

    @Test
    void isKnightsSafe() {
        Integer[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        boolean result = Task8.knightBoardCapture(board);

        assertThat(result).isEqualTo(true);
    }

    @Test
    void isKnightsNotSafe() {
        Integer[][] board = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        boolean result = Task8.knightBoardCapture(board);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void isKnightsNotSafe1() {
        Integer[][] board = {
            {1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1}
        };

        boolean result = Task8.knightBoardCapture(board);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void checkIfBoardWithWrongSize() {
        Integer[][] board = {
            {1, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0}
        };

        Assertions.assertThrows(IllegalArgumentException.class, () -> Task8.knightBoardCapture(board));
    }

}
