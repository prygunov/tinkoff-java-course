package edu.project2.finder;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

public class DFFinder implements Finder {
    @Override
    public List<Cell> find(Maze maze, Cell start, Cell end) {
        if (start.type() == Cell.Type.WALL || end.type() == Cell.Type.WALL) {
            throw new IllegalArgumentException();
        }

        HashSet<Cell> visitedCells = new LinkedHashSet<>();
        Stack<Cell> cellStack = new Stack<>();
        cellStack.push(start);
        while (!cellStack.isEmpty()) {
            Cell nextCell = cellStack.pop();
            visitedCells.add(nextCell);

            if (nextCell == end) {
                return List.copyOf(visitedCells);
            }

            for (var neighbour : maze.getNeighboursOf(nextCell)) {
                if (neighbour.type() != Cell.Type.WALL && !visitedCells.contains(neighbour)) {
                    cellStack.push(neighbour);
                }
            }
        }

        return List.of();
    }
}
