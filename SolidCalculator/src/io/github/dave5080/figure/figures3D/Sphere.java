package io.github.dave5080.figure.figures3D;

import io.github.dave5080.figure.*;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;
import static java.lang.Math.PI;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Sphere extends AbstractSolid {

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

    public boolean run(Scanner scan) throws Exception {
        range = readValue(scan, "Inserire il raggio: ");
        return true;
    }
}
