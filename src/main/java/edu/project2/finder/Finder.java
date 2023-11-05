package edu.project2.finder;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.List;

public interface Finder {
    List<Cell> find(Maze maze, Cell start, Cell end);
}
