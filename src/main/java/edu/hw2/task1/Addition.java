package edu.hw2.task1;

public record Addition(Expr expr1, Expr expr2) implements Expr {

    public Addition(Expr expr, double n) {
        this(expr, new Constant(n));
    }

    public Addition(double n, Expr expr) {
        this(new Constant(n), expr);
    }

    public Addition(double n1, double n2) {
        this(new Constant(n1), new Constant(n2));
    }

    @Override
    public double evaluate() {
        return expr1.evaluate() + expr2.evaluate();
    }

    @Override
    public String toString() {
        return Double.toString(evaluate());
    }
}
