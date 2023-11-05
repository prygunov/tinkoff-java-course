package edu.project2.finder;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFFinder implements Finder {
    @Override
    public List<Cell> find(Maze maze, Cell start, Cell end) {
        if (start.type() == Cell.Type.WALL || end.type() == Cell.Type.WALL) {
            throw new IllegalArgumentException();
        }

        Set<Cell> visitedCells = new LinkedHashSet<>();
        LinkedList<Cell> cellQueue = new LinkedList<>();
        cellQueue.addFirst(start);
        while (!cellQueue.isEmpty()) {
            Cell nextCell = cellQueue.pollLast();
            visitedCells.add(nextCell);

            if (nextCell == end) {
                return List.copyOf(visitedCells);
            }

            for (var neighbour : maze.getNeighboursOf(nextCell)) {
                if (neighbour.type() != Cell.Type.WALL && !visitedCells.contains(neighbour)) {
                    cellQueue.addFirst(neighbour);
                }
            }
        }

        return null;
    }
}
