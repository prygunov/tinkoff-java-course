package edu.project2;

import edu.project2.finder.AStarFinder;
import edu.project2.finder.BFFinder;
import edu.project2.finder.DFFinder;
import edu.project2.maze.Cell;
import edu.project2.maze.FirstFreeCellsGenerator;
import edu.project2.maze.Maze;
import edu.project2.maze.RecursiveBacktrackingMazeGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ComplexMazeTest {

    static List<Maze> randomMazes() {
        ArrayList<Maze> mazes = new ArrayList<>();
        var mazeGenerator = new RecursiveBacktrackingMazeGenerator(10, 10);
        for (int i = 0; i < 5; i++) {
            mazes.add(mazeGenerator.generate());
        }
        return mazes;
    }

    @ParameterizedTest
    @MethodSource("randomMazes")
    void testDF(Maze maze) {
        Cell[] freeCells = new FirstFreeCellsGenerator().generate(maze);

        var finder = new DFFinder();
        var result = finder.find(maze, freeCells[0], freeCells[1]);
        assertFalse(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("randomMazes")
    void testAStar(Maze maze) {
        Cell[] freeCells = new FirstFreeCellsGenerator().generate(maze);

        var finder = new AStarFinder();
        var result = finder.find(maze, freeCells[0], freeCells[1]);
        assertFalse(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("randomMazes")
    void testBF(Maze maze) {
        Cell[] freeCells = new FirstFreeCellsGenerator().generate(maze);

        var finder = new BFFinder();
        var result = finder.find(maze, freeCells[0], freeCells[1]);
        assertFalse(result.isEmpty());
    }
}
