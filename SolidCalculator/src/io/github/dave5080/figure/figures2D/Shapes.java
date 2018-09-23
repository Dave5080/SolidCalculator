package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

/**
 * This enumeration lists the Flat Figures and it's an easy way to get instances of those.
 */
public enum Shapes{

    RECTANGLE(Rectangle.class),
    CIRCLE(Circle.class),
    REGULAR_FIGURE(RegularFigure.class);

    /**
     * The class implementing {@link AbstractShape} with the details of each {@link Shapes}
     */
    private Class<? extends AbstractShape> shapeClass;

    /**
     * This simple constructor link a {@link Shapes} record with an {@link AbstractShape} class implementation
     * @param shapeClass The implemented class of the figure witch defines all his details
     */
    Shapes(Class<? extends AbstractShape> shapeClass) {
        this.shapeClass = shapeClass;
    }

    /**
     * @return A new instance of the Shape
     */
    public AbstractShape getShape(){
        try {
            return shapeClass.getConstructor().newInstance();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
