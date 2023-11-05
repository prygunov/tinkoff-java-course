package edu.project2;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.List;

public class ConsoleRenderer implements Renderer {
    private final static char WALL_CHAR = '█';
    private final static char PATH = '.';
    private final static char EMPTY = ' ';
    private final static char START = 'S';
    private final static char END = 'E';

    @Override
    public String render(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();

        StringBuilder mazeString = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = maze.getCell(i, j);
                mazeString.append(getPrettyCharacters(cell, maze));
            }
            mazeString.append("\n");
        }

        return mazeString.toString();
    }

    @Override
    public String render(Maze maze, List<Cell> path) {
        char[][] result = new char[maze.getHeight()][maze.getWidth()];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell cell = maze.getCell(i, j);

                char ch = getPrettyCharacters(cell, maze);
                result[i][j] = ch;
            }
        }

        for (int i = 0; i < path.size(); i++) {
            Cell cell = path.get(i);
            char ch = i == 0 ? START : i == path.size() - 1 ? END : PATH;
            result[cell.row()][cell.col()] = ch;
        }

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private char getPrettyCharacters(Cell cell, Maze maze) {
        if (cell.type() != Cell.Type.WALL) {
            return EMPTY;
        }

        var leftCell = maze.leftCellOf(cell);
        var rightCell = maze.rightCellOf(cell);
        var upCell = maze.upCellOf(cell);
        var downCell = maze.downCellOf(cell);

        if ((leftCell.type() == Cell.Type.WALL)
            || (rightCell.type() == Cell.Type.WALL)) {
            return WALL_CHAR;
        }

        if ((upCell.type() == Cell.Type.WALL)
            || (downCell.type() == Cell.Type.WALL)) {
            return WALL_CHAR;
        }

        return WALL_CHAR;
    }
}
