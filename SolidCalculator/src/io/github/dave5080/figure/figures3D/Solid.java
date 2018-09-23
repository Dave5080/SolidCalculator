package io.github.dave5080.figure.figures3D;

import io.github.dave5080.figure.IAbstractSolid;

/**
 * This enumeration lists the Solid Figures Families and creates new instances
 * for every new one..
 */
public enum Solid{
    PRISM(Prism.class),
    PYRAMID(Pyramid.class),
    SPHERE(Sphere.class);

    /**
     * The class implementing {@link IAbstractSolid} with the details of each {@link Solid}
     */
    private Class<? extends IAbstractSolid> solidClass;

    /**
     * This simple constructor link a {@link Solid} record with an {@link IAbstractSolid} class implementation
     * @param solidClass The implemented class of the figure witch defines all his details
     */
    Solid(Class<? extends IAbstractSolid> solidClass){
        this.solidClass = solidClass;
    }

    /**
     * @return A new instance of the Solid
     */
    public IAbstractSolid getSolid(){
        try {
            return solidClass.getConstructor().newInstance();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}