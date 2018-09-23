package io.github.dave5080.figure.figures3D;

import io.github.dave5080.Main;
import io.github.dave5080.figure.*;
import io.github.dave5080.figure.figures2D.Shapes;

import java.util.Arrays;
import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Pyramid implements AbstractSolid {

    /**
     * Stores Solid's height
     */
    private double height;
    /**
     * Indentify the Solid's base shape
     */
    private AbstractShape abstractShape;

    /**
     * Volume = Base's Area * Solid's Height / 3
     * See {@link AbstractSolid#getVolume()}
     */
    @Override
    public double getVolume() {
        return (abstractShape.getArea()*height)/3;
    }

    /**
     * See {@link AbstractSolid#getLateralArea()}
     */
    @Override
    public double getLateralArea() throws IllegalAccessException {
        return abstractShape.getPerimeter()* (AbstractSolid.pitagor(abstractShape.getApothem(), height)/2);
    }

    /**
     * Total Area = Base's Area * Solid's Lateral Area
     * See {@link AbstractSolid#getTotalArea()}
     */
    @Override
    public double getTotalArea() throws IllegalAccessException {
        return getLateralArea()+ abstractShape.getArea();
    }

    /**
     * Used to read the Solid's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    public boolean run(Scanner scan) throws Exception {
        Arrays.stream(Shapes.values())
                .filter(x -> !x.name().equals("RECTANGLE"))
                .forEach(solid -> System.out.printf("%s ",solid.name()));
        System.out.print("\nInserire il tipo di base: ");
        Shapes aShape = Shapes.valueOf(scan.nextLine().toUpperCase());
        if(aShape.equals(Shapes.RECTANGLE))
            return false;
        abstractShape = aShape.getShape();
        if(abstractShape != null){
            Main.getInputHandler().execute(this.abstractShape);
            height = readValue(scan, "Inserire l'altezza della piramide: ");
            return true;
        }
        return false;
    }
}
