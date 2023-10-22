package edu.hw2.task2;

public class Rectangle extends Quad {

    private int width;
    private int height;

    public final void setWidth(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width cannot be zero or negative");
        }
        this.width = width;
    }

    public final void setHeight(int height) {
        if (width < 1) {
            throw new IllegalArgumentException("Height cannot be zero or negative");
        }
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

