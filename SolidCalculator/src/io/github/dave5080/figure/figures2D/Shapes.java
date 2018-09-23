package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;

/**
 * This enumeration lists the Flat Figures and it's an easy way to get instances of those.
 */
public enum Shapes{

    RECTANGLE(Rectangle.class),
    CIRCLE(Circle.class),
    REGULAR_FIGURE(RegularFigure.class);

    private Class<? extends AbstractShape> shapeClass;

    Shapes(Class<? extends AbstractShape> shapeClass) {
        this.shapeClass = shapeClass;
    }

    public AbstractShape getShape(){
        try {
            return shapeClass.getConstructor().newInstance();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
