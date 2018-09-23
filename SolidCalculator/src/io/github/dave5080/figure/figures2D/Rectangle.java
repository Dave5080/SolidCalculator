package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"RedundantThrows", "SpellCheckingInspection"})
public class Rectangle implements AbstractShape {

    /**
     * The base lenght of the rectangle
     */
    private double base;
    /**
     * The height lenght of the rectangle
     */
    private double height;

    /**
     * See {@link AbstractShape#getArea()}
     */
    @Override
    public double getArea() {
        return base*height;
    }

    /**
     * See {@link AbstractShape#getPerimeter()}
     */
    @Override
    public double getPerimeter() {
        return (base+height)*2;
    }

    /**
     * See {@link AbstractShape#getApothem()}
     */
    @Override
    public double getApothem() throws IllegalAccessException {
        if(base == height)
            return base/2;
        throw new IllegalAccessException("Un rettangolo non può avere un'apotema!");
    }

    /**
     * Used to read the Shape's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    @Override
    public boolean run(Scanner scan) throws Exception {
        base = readValue(scan, "Inserire la base: ");
        height = readValue(scan, "Inserire l'altezza: ");
        return true;
    }
}
