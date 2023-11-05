package edu.project2.finder;

import edu.project2.maze.Cell;
import java.util.Comparator;

public class AStarHeuristic implements Comparator<Cell> {

    private final Cell end;

    public AStarHeuristic(Cell end) {
        this.end = end;
    }

    @Override
    public int compare(Cell o1, Cell o2) {
        return (int) (getHeuristic(o1) - getHeuristic(o2));
    }

    private double getHeuristic(Cell cell) {
        int dx = end.col() - cell.col();
        int dy = end.row() - cell.row();
        return dx * dx + dy * dy;
    }
}
