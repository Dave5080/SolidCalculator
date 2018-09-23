package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

import java.util.Scanner;

@SuppressWarnings("RedundantThrows")
public class Rectangle extends AbstractShape {

    private double base;
    private double height;

    @Override
    public double getArea() {
        return base*height;
    }

    @Override
    public double getPerimeter() {
        return (base+height)*2;
    }

    @Override
    public double getApothem() throws Exception {
        throw new Exception();
    }

    @Override
    public boolean run(Scanner scan) throws Exception {
        return false;
    }
}
