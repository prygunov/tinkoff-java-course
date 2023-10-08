package edu.hw1;

import java.util.Objects;

public final class Task8 {

    private static final int[] DX = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 1, -1, 2, -2, 2, -2};
    public static final int BOARD_SIZE = 8;

    private Task8() {
    }

    public static boolean knightBoardCapture(Integer[][] board) {
        Objects.requireNonNull(board);
        if (board.length != BOARD_SIZE || board[0].length != BOARD_SIZE) {
            throw new IllegalArgumentException("Board size must be 8");
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != 1) {
                    continue;
                }
                for (int k = 0; k < BOARD_SIZE; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x >= 0
                        && x < BOARD_SIZE
                        && y >= 0
                        && y < BOARD_SIZE
                        && board[x][y] == 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
