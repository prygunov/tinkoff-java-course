package edu.hw2.task2;

public final class Square extends Rectangle {

    public void setSide(int side) {
        if (side < 1) {
            throw new IllegalArgumentException("Side cannot be zero or negative");
        }
        super.setWidth(side);
        super.setHeight(side);
    }

}
