package io.github.dave5080.figure.figures3D;

import io.github.dave5080.figure.*;

import java.util.Scanner;

import static io.github.dave5080.InputHandler.readValue;
import static java.lang.Math.PI;

@SuppressWarnings({"SpellCheckingInspection", "RedundantThrows"})
public class Sphere extends AbstractSolid {

    private double range;

    /**
     * See {@link AbstractSolid#getVolume()}
     */
    @Override
    public double getVolume() {
        return (4*PI*Math.pow(range,3))/3;
    }

    /**
     * See {@link AbstractSolid#getLateralArea()}
     */
    @Override
    public double getLateralArea() {
        return 4*PI*Math.pow(range,2);
    }

    /**
     * See {@link AbstractSolid#getTotalArea()}
     */
    @Override
    public double getTotalArea() {
        return getLateralArea();
    }

    /**
     * Used to read the Solid's height and the Base shape's info
     * @see io.github.dave5080.DataReader
     * @see io.github.dave5080.InputHandler
     */
    public boolean run(Scanner scan) throws Exception {
        range = readValue(scan, "Inserire il raggio: ");
        return true;
    }
}
