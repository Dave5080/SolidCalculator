package io.github.dave5080.figure.figures2D;

import io.github.dave5080.DataReader;
import io.github.dave5080.figure.AbstractShape;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings("SpellCheckingInspection")
public class RegularFigure extends AbstractShape implements DataReader{
    private static final double[] fixedNumbers = {0.289,0.5,0.688,0.866,1.038,1.207,1.374,1.539,1.703,1.866};
    private int sideNumber;
    private double side;
    private double apothem;
    private double fixedNumber = 0;
    @Override
    public double getArea() {
        return getPerimeter()* apothem /2;
    }

    @Override
    public double getPerimeter() {
        return side*sideNumber;
    }

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

    public boolean run(Scanner scan) throws Exception {
        System.out.print("Inserire il numero di lati: ");
        sideNumber = scan.nextInt();
        if(sideNumber <= 0)
            throw new Exception();
        side = readValue(scan, "Inserire il lato: ");
        apothem = getApothem();
        return true;
    }
}
