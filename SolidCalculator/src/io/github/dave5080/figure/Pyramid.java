package io.github.dave5080.figure;

import io.github.dave5080.InputHandler;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Pyramid extends AbstractFigure{

    private double height;
    private AbstractFigure.Shape shape;

    @Override
    public double getVolume() {
        return (shape.getArea()*height)*3;
    }

    @Override
    public double getLateralArea() throws Exception {
        return shape.getPerimeter()*shape.getApothem()/2;
    }

    @Override
    public double getTotalArea() throws Exception {
        return getLateralArea()+shape.getArea();
    }

    @Override
    public void scanForInfo(Scanner input) {
        new InputHandler(System.in, System.err, "\nValore non valido\n") {
            @Override
            public boolean run(Scanner scan) throws Exception {
                Arrays.stream(Shapes.values())
                        .filter(x -> !x.name().equals("RECTANGLE"))
                        .forEach(solid -> System.out.printf("%s ",solid.name()));
                System.out.print("\nInserire il tipo di base: ");
                AbstractFigure.Shapes aShape = AbstractFigure.Shapes.valueOf(scan.nextLine().toUpperCase());
                if(aShape.equals(Shapes.RECTANGLE))
                    return false;
                shape = aShape.getShape();
                if(shape != null){
                    shape.getInfo(new Scanner(System.in));
                    height = readValue(scan, "Inserire l'altezza della piramide: ");
                    return true;
                }
                return false;
            }
        }.execute();
    }

}
