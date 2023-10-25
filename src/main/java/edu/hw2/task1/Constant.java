package edu.hw2.task1;

public record Constant(double val) implements Expr {

    public Constant(Expr expr) {
        this(expr.evaluate());
    }

    @Override
    public double evaluate() {
        return val;
    }

    @Override
    public String toString() {
        return Double.toString(evaluate());
    }
}
