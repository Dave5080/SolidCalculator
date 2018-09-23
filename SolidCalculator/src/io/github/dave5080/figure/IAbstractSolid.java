package io.github.dave5080.figure;

import io.github.dave5080.DataReader;
import io.github.dave5080.figure.figures3D.Prism;
import io.github.dave5080.figure.figures3D.Pyramid;
import io.github.dave5080.figure.figures3D.Sphere;

/**
 * An {@link RegularFigure} is the abstract form of any solid implementable
 * There are 2 subcategories of Solid Figures:
 * <br/>
 * - Elevating solid from regular shapes ({@link Prism} and {@link Pyramid} <br/>
 * - Solid built only by shapes like the {@link Sphere}
 */
@SuppressWarnings("ALL")
public interface IAbstractSolid extends DataReader {

    /**
     * Just a simple math implementation of the Pitagor's theory
     * @param c1 First lesser side of the triangle
     * @param c2 Secnd lesser side of the triangle
     * @return Returns the greater side of the triangle
     */
    public static double pitagor (double c1, double c2){
        return (Math.sqrt(Math.pow(c1,2)+Math.pow(c2,2)));
    }

    /**
     * @return the volume of the solid.
     */
    public abstract double getVolume();

    /**
     * @return the lateral area of the solid
     * @throws Exception when the solid has not a lateral area (i.e. {@link Sphere}
     */
    public abstract double getLateralArea() throws Exception;

    /**
     * @return the total area of the solid.
     */
    public abstract double getTotalArea() throws IllegalAccessException;

}