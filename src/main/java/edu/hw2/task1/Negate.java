package edu.hw2.task1;

public record Negate(Expr expr) implements Expr {

    public Negate(double n) {
        this(new Constant(n));
    }

    @Override
    public double evaluate() {
        return -expr.evaluate();
    }

}
