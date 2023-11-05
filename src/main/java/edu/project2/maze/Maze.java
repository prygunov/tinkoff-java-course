package edu.project2.maze;

import java.util.ArrayList;
import java.util.List;

public final class Maze {
    public static final int MAX_NEIGHBOURS = 4;
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        if (grid.length != height) {
            throw new IllegalArgumentException("Invalid grid height");
        }
        if (grid[0].length != width) {
            throw new IllegalArgumentException("Invalid grid width");
        }

        this.height = height;
        this.width = width;
        this.grid = grid;
    }

    public Cell getCell(int i, int j) {
        return grid[i][j];
    }

    public Cell leftCellOf(Cell cell) {
        if (cell.col() > 0) {
            return getCell(cell.row(), cell.col() - 1);
        }
        return Cell.WALL;
    }

    public Cell rightCellOf(Cell cell) {
        if (cell.col() < width - 1) {
            return getCell(cell.row(), cell.col() + 1);
        }
        return Cell.WALL;
    }

    public Cell upCellOf(Cell cell) {
        if (cell.row() > 0) {
            return getCell(cell.row() - 1, cell.col());
        }
        return Cell.WALL;
    }

    public Cell downCellOf(Cell cell) {
        if (cell.row() < height - 1) {
            return getCell(cell.row() + 1, cell.col());
        }
        return Cell.WALL;
    }

    public List<Cell> getNeighboursOf(Cell cell) {
        var result = new ArrayList<Cell>(MAX_NEIGHBOURS);

        int cellI = cell.row();
        int cellJ = cell.col();

        int newCellI = cellI - 1;
        if (newCellI >= 0) {
            result.add(getCell(newCellI, cellJ));
        }

        newCellI = cellI + 1;
        if (newCellI < height) {
            result.add(getCell(newCellI, cellJ));
        }

        int newCellJ = cellJ - 1;
        if (newCellJ >= 0) {
            result.add(getCell(cellI, newCellJ));
        }

        newCellJ = cellJ + 1;
        if (newCellJ < width) {
            result.add(getCell(cellI, newCellJ));
        }

        return result;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
