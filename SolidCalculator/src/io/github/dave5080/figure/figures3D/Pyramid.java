package io.github.dave5080.figure.figures3D;

import io.github.dave5080.InputHandler;
import io.github.dave5080.Main;
import io.github.dave5080.figure.*;
import io.github.dave5080.figure.figures2D.Shapes;

import java.util.Arrays;
import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Pyramid extends AbstractSolid {

    private double height;
    private AbstractShape AbstractShape;

    @Override
    public double getVolume() {
        return (AbstractShape.getArea()*height)*3;
    }

    @Override
    public double getLateralArea() throws Exception {
        return AbstractShape.getPerimeter()* AbstractShape.getApothem()/2;
    }

    @Override
    public double getTotalArea() throws Exception {
        return getLateralArea()+ AbstractShape.getArea();
    }

    public boolean run(Scanner scan) throws Exception {
        Arrays.stream(Shapes.values())
                .filter(x -> !x.name().equals("RECTANGLE"))
                .forEach(solid -> System.out.printf("%s ",solid.name()));
        System.out.print("\nInserire il tipo di base: ");
        Shapes aShape = Shapes.valueOf(scan.nextLine().toUpperCase());
        if(aShape.equals(Shapes.RECTANGLE))
            return false;
        AbstractShape = aShape.getShape();
        if(AbstractShape != null){
            Main.getInputHandler().execute(this.AbstractShape);
            height = readValue(scan, "Inserire l'altezza della piramide: ");
            return true;
        }
        return false;
    }
}
