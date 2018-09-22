package io.github.dave5080.figure;

import io.github.dave5080.InputHandler;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Sphere extends AbstractFigure{

    private double range;

    @Override
    public double getVolume() {
        return (4*PI*Math.pow(range,3))/3;
    }

    @Override
    public double getLateralArea() {
        return 4*PI*Math.pow(range,2);
    }

    @Override
    public double getTotalArea() {
        return getLateralArea();
    }

    @Override
    public void scanForInfo(Scanner scan) {
        new InputHandler(System.in, "\nValore non valido!\n") {
            @Override
            public boolean run(Scanner scan) throws Exception {
                range = readValue(scan, "Inserire il raggio: ");
                return true;
            }
        }.execute();
    }
}
