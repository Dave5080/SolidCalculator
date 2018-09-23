package io.github.dave5080.figure;

import io.github.dave5080.DataReader;

/**
 * An {@link AbstractShape} is the abstract form of any shape implementable
 * All the shapes that extend this class are listed in the {@link io.github.dave5080.figure.figures2D.Shapes} enum
 */
public abstract class AbstractShape implements DataReader{
    /**
     * @return The area of the shape
     */
    public abstract double getArea();

    /**
     * @return The perimeter of the shape
     */
    public abstract double getPerimeter();

    /**
     *
     * @return The apthem of the shape.
     * @throws IllegalAccessError when the shape has not an apothem
     *                            (i.e. {@link io.github.dave5080.figure.figures2D.Rectangle})
     */
    public abstract double getApothem() throws IllegalAccessException;
}
