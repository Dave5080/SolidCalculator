package io.github.dave5080.figure.figures3D;

import io.github.dave5080.figure.AbstractSolid;

/**
 * This enumeration lists the Solid Figures Families and creates new instances
 * for every new one..
 */
public enum Solid{
    PRISM(Prism.class),
    PYRAMID(Pyramid.class),
    SPHERE(Sphere.class);

    private Class<? extends AbstractSolid> solidClass;

    /**
     * This simple constructor link a {@link Solid} record with an {@link AbstractSolid} class implementation
     * @param solidClass The implemented class of the figure witch defines all his details
     */
    Solid(Class<? extends AbstractSolid> solidClass){
        this.solidClass = solidClass;
    }

    /**
     * @return A new instance of the Solid
     */
    public AbstractSolid getSolid(){
        try {
            return solidClass.getConstructor().newInstance();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}