package io.github.dave5080.figure.figures3D;

import io.github.dave5080.Main;
import io.github.dave5080.figure.*;
import io.github.dave5080.figure.figures2D.Shapes;

import java.util.Arrays;
import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Prism extends AbstractSolid {

    private double height;
    private AbstractShape abstractShape;


    @Override
    public double getVolume() {
        return abstractShape.getArea() * height;
    }

    @Override
    public double getLateralArea() {
        return abstractShape.getPerimeter() * height;
    }

    @Override
    public double getTotalArea() {
        return getLateralArea() + (abstractShape.getArea() * 2);
    }


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