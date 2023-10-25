package edu.hw2.task1;

public record Multiplication(Expr expr1, Expr expr2) implements Expr {

    public Multiplication(Expr expr, double n) {
        this(expr, new Constant(n));
    }

    public Multiplication(double n, Expr powerExp) {
        this(new Constant(n), powerExp.evaluate());
    }

    public Multiplication(double n1, double n2) {
        this(new Constant(n1), new Constant(n2));
    }

    @Override
    public double evaluate() {
        return expr1.evaluate() * expr2.evaluate();
    }

    @Override
    public String toString() {
        return Double.toString(evaluate());
    }

}
