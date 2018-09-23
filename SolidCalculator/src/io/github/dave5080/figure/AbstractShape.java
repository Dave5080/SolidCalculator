package io.github.dave5080.figure;

import io.github.dave5080.DataReader;


/**
 * This enums list all implementable 2D shapes applicable to the 3D ones
 */
public abstract class AbstractShape implements DataReader{
    /**
     *
     * @return
     */
    public abstract double getArea();

    /**
     *
     * @return
     */
    public abstract double getPerimeter();

    /**
     *
     * @return
     * @throws Exception
     */
    public abstract double getApothem() throws Exception;
}
