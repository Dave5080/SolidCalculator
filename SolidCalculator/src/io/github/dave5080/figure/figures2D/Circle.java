package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

import java.util.Scanner;

import static java.lang.Math.PI;

@SuppressWarnings("RedundantThrows")
public class Circle extends AbstractShape {
    private double range;
    @Override
    public double getArea() {
        return PI*Math.pow(range,2);
    }

    @Override
    public double getPerimeter() {
        return 2*PI*range;
    }

    @Override
    public double getApothem() {
        return range;
    }

    @Override
    public boolean run(Scanner scan) throws Exception {
        return false;
    }
}