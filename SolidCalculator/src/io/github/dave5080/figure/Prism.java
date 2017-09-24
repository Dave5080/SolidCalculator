package io.github.dave5080.figure;

import io.github.dave5080.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Prism extends AbstractFigure{

    private double height;
    private AbstractFigure.Shape shape;


    @Override
    public double getVolume() {
        return shape.getArea()*height;
    }

    @Override
    public double getLateralArea() {
        return shape.getPerimeter()*height;
    }

    @Override
    public double getTotalArea() {
        return getLateralArea()+(shape.getArea()*2);
    }

    @Override
    public void scanForInfo(Scanner scan) {
        new Main(System.in, "\nValore non valido\n") {
            @Override
            public boolean run(Scanner scan) throws Exception {
                Arrays.asList(AbstractFigure.Shapes.values()).forEach(figure -> System.out.printf("%s ",figure.name()));
                System.out.print("\nInserire la figura di base: ");
                shape = AbstractFigure.Shapes.valueOf(scan.nextLine().toUpperCase()).getShape();
                if(shape != null){
                    shape.getInfo(new Scanner(System.in));
                    height = readValue(scan, "Inserire l'altezza del prisma: ");
                    return true;
                }
                return false;
            }
        }.execute();
    }
}
