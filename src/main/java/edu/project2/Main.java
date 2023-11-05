package edu.project2;

import edu.project2.finder.DFFinder;
import edu.project2.finder.Finder;
import edu.project2.maze.Cell;
import edu.project2.maze.FirstFreeCellsGenerator;
import edu.project2.maze.Maze;
import edu.project2.maze.MazeGenerator;
import edu.project2.maze.RecursiveBacktrackingMazeGenerator;
import java.util.List;
import java.util.logging.Logger;

public class Main {



    private static final int INIT_WIDTH = 10;
    private static final int INIT_HEIGHT = 10;

    private Main() {

    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        MazeGenerator generator = new RecursiveBacktrackingMazeGenerator(INIT_WIDTH, INIT_HEIGHT);
        Maze maze = generator.generate();
        Renderer renderer = new ConsoleRenderer();
        logger.info(renderer.render(maze));

        Finder finder = new DFFinder();

        Cell[] freeCells = new FirstFreeCellsGenerator().generate(maze);

        List<Cell> path = finder.find(maze, freeCells[0], freeCells[1]);
        logger.info(renderer.render(maze, path));
    }

}
