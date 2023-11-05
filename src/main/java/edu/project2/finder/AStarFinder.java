package edu.project2.finder;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class AStarFinder implements Finder {
    @Override
    public List<Cell> find(Maze maze, @NotNull Cell start, @NotNull Cell end) {
        if (start.type() == Cell.Type.WALL || end.type() == Cell.Type.WALL) {
            throw new IllegalArgumentException();
        }

        Set<Cell> visitedCells = new LinkedHashSet<>();
        PriorityQueue<Cell> cellQueue = new PriorityQueue<>(new AStarHeuristic(end));
        cellQueue.add(start);
        while (!cellQueue.isEmpty()) {
            Cell nextCell = cellQueue.poll();
            visitedCells.add(nextCell);

            if (nextCell == end) {
                return List.copyOf(visitedCells);
            }

            for (var neighbour : maze.getNeighboursOf(nextCell)) {
                if (neighbour.type() != Cell.Type.WALL && !visitedCells.contains(neighbour)) {
                    cellQueue.add(neighbour);
                }
            }
        }
        return List.of(); // we didn't find a path
    }
}
