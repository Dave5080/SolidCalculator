package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.IAbstractShape;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"SpellCheckingInspection"})
public class RegularFigure implements IAbstractShape {

    /**
     * An array containing all fixed numbers of the Regular Figures with 4-12 sides.
     */
    private static final double[] fixedNumbers = {0.289,0.5,0.688,0.866,1.038,1.207,1.374,1.539,1.703,1.866};
    /**
     * Number of sides of the figure.
     */
    private int sideNumber;
    /**
     * Lenght of a side of the figure.
     */
    private double side;
    /**
     * Lenght og the apothem of the figure.
     */
    private double apothem;
    /**
     * The fixed number of the figure
     */
    private double fixedNumber = 0;

    /**
     * See {@link IAbstractShape#getArea()}
     */
    @Override
    public double getArea() {
        return getPerimeter()* apothem /2;
    }

    /**
     * See {@link IAbstractShape#getPerimeter()}
     */
    @Override
    public double getPerimeter() {
        return side*sideNumber;
    }

    /**
     * See {@link IAbstractShape#getApothem()}
     */
    @Override
    public double getApothem() {
        try{
            fixedNumber = fixedNumbers[sideNumber-3];
        } catch (ArrayIndexOutOfBoundsException e){
            if(fixedNumber == 0)
                fixedNumber = readValue(new Scanner(System.in), "Inserire il numero fisso: ");
        }
            return fixedNumber*side;
    }

    /**
     * Used to read the Shape's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    public boolean run(Scanner scan) throws IllegalArgumentException {
        sideNumber = (int) readValue(scan,
                "Inserire il numero di lati: ",
                "Numero di lati non valido!",
                value -> value >=4);
        side = readValue(scan, "Inserire il lato: ");
        apothem = getApothem();
        return true;
    }
}
