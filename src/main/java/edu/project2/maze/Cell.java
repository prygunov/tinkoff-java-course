package edu.project2.maze;

public record Cell(int row, int col, Type type) {
    public static final Cell WALL = new Cell(-1, -1, Type.WALL);

    public enum Type {
        WALL, PASSAGE
    }
}
