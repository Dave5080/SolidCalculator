package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.IAbstractShape;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;
import static java.lang.Math.PI;

@SuppressWarnings({"RedundantThrows", "SpellCheckingInspection"})
public class Circle implements IAbstractShape {

    /**
     * The range lenght of the circle.
     */
    private double range;

    /**
     * See {@link IAbstractShape#getArea()}
     */
    @Override
    public double getArea() {
        return PI*Math.pow(range,2);
    }

    /**
     * See {@link IAbstractShape#getPerimeter()}
     */
    @Override
    public double getPerimeter() {
        return 2*PI*range;
    }

    /**
     * See {@link IAbstractShape#getApothem()}
     */
    @Override
    public double getApothem() {
        return range;
    }
    /**
     * Used to read the Shape's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    @Override
    public boolean run(Scanner scan) throws Exception {
        range = readValue(scan, "Inserire il raggio del cerchio: ");
        return true;
    }
}