package edu.hw2.task1;

public record Exponent(Expr expr, double power) implements Expr {

    public Exponent(Expr expr, Expr powerExp) {
        this(expr, powerExp.evaluate());
    }

    public Exponent(double n, Expr powerExp) {
        this(new Constant(n), powerExp.evaluate());
    }

    public Exponent(double n1, double n2) {
        this(new Constant(n1), new Constant(n2));
    }

    @Override
    public double evaluate() {
        //Math.exp?
        return Math.pow(expr.evaluate(), power);
    }

    @Override
    public String toString() {
        return Double.toString(evaluate());
    }

}
