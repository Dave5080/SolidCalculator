package io.github.dave5080.figure.figures3D;

import io.github.dave5080.Main;
import io.github.dave5080.figure.*;
import io.github.dave5080.figure.figures2D.Shapes;

import java.util.Arrays;
import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Prism implements AbstractSolid {

    /**
     * Stores Solid's height
     */
    private double height;
    /**
     * Indentify the Solid's base shape
     */
    private AbstractShape abstractShape;

    /**
     * Volume = Base's Area * Solid's Height
     * See {@link AbstractSolid#getVolume()}
     */
    @Override
    public double getVolume() {
        return abstractShape.getArea() * height;
    }

    /**
     * Lateral Area = Bas's Perimeter * Solid's Height
     * See {@link AbstractSolid#getLateralArea()}
     */
    @Override
    public double getLateralArea() {
        return abstractShape.getPerimeter() * height;
    }

    /**
     * TotalArea = 2 * Base's Area + Solid's Lateral Area
     * See {@link AbstractSolid#getTotalArea()}
     */
    @Override
    public double getTotalArea() {
        return getLateralArea() + (abstractShape.getArea() * 2);
    }

    /**
     * Used to read the Solid's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    public boolean run(Scanner scan) throws Exception {
        Arrays.asList(Shapes.values()).forEach(figure -> System.out.printf("%s ",figure.name()));
        System.out.print("\nInserire la figura di base: ");
        abstractShape = Shapes.valueOf(scan.nextLine().toUpperCase()).getShape();
        if(abstractShape != null){
            Main.getInputHandler().execute(abstractShape);
            height = readValue(scan, "Inserire l'altezza del prisma: ");
            return true;
        }
        return false;
    }
}