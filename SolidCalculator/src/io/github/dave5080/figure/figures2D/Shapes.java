package io.github.dave5080.figure.figures2D;

import io.github.dave5080.figure.AbstractShape;
import io.github.dave5080.figure.AbstractSolid;

public enum Shapes{

    RECTANGLE(Rectangle.class),
    CIRCLE(Circle.class),
    FIGURE(RegularFigure.class);

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
