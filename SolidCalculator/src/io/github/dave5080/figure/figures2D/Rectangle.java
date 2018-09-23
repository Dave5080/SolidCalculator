package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"RedundantThrows", "SpellCheckingInspection"})
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
    public double getApothem() throws IllegalAccessException {
        if(base == height)
            return base/2;
        throw new IllegalAccessException("Un rettangolo non può avere un'apotema!");
    }

    @Override
    public boolean run(Scanner scan) throws Exception {
        base = readValue(scan, "Inserire la base: ");
        height = readValue(scan, "Inserire l'altezza: ");
        return true;
    }
}
