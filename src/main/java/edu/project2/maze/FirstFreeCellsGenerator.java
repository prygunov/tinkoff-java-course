package edu.project2.maze;

public class FirstFreeCellsGenerator implements FreeCellsGenerator {
    @Override
    public Cell[] generate(Maze maze) {
        Cell[] freeCells = new Cell[2];
        startCell:
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getCell(i, j).type() != Cell.Type.WALL) {
                    freeCells[0] = maze.getCell(i, j);
                    break startCell;
                }
            }
        }

        endCell:
        for (int i = maze.getHeight() - 1; i > 0; i--) {
            for (int j = maze.getWidth() - 1; j > 0; j--) {
                if (maze.getCell(i, j).type() != Cell.Type.WALL) {
                    freeCells[1] = maze.getCell(i, j);
                    break endCell;
                }
            }
        }

        return freeCells;
    }
}
