package io.github.dave5080.figure;

import io.github.dave5080.Main;

import java.util.Scanner;

@SuppressWarnings("ALL")
public abstract class AbstractFigure {

    public static final float PI = 3.14F;

    public static double readValue(Scanner scan, String request) throws Exception {
        System.out.print(request);
        double value = scan.nextDouble();
        if(value > 0)
            return value;
        else
            throw new Exception();
    }

    public static double pitagor (double c1, double c2){
        return (Math.sqrt(Math.pow(c1,2)+Math.pow(c2,2)));
    }

    public enum Solid{
        PRISM(Prism.class),
        PYRAMID(Pyramid.class),
        SPHERE(Sphere.class);

        private Class<? extends AbstractFigure> solidClass;

        Solid(Class<? extends AbstractFigure> c){
            this.solidClass = c;
        }

        public AbstractFigure getSolid(){
            try {
                return solidClass.getConstructor().newInstance();
            } catch (Exception e) { e.printStackTrace(); }
            return null;
        }
    }

    public abstract static class Shape{
        public abstract double getArea();
        public abstract double getPerimeter();
        public abstract void getInfo(Scanner scan);
        public abstract double getApothem() throws Exception;
    }

    public enum Shapes{

        RECTANGLE(new Shape() {

            private double base;
            private double height;

            @Override
            public double getArea() {
                return base*height;
            }

            @Override
            public double getPerimeter() {
                return (base+height)*2;
            }

            @Override
            public void getInfo(Scanner scan) {
                new Main(System.in, "\nValore non valido!\n") {
                    @Override
                    public boolean run(Scanner scan) throws Exception {
                        base = readValue(scan, "Inserire la base: ");
                        height = readValue(scan, "Inserire l'altezza: ");
                        return true;
                    }
                }.execute();
            }

            @Override
            public double getApothem() throws Exception {
                throw new Exception();
            }
        }),

        CIRCLE(new Shape() {
            double range;
            @Override
            public double getArea() {
                return PI*Math.pow(range,2);
            }

            @Override
            public double getPerimeter() {
                return 2*PI*range;
            }

            @Override
            public void getInfo(Scanner scan) {
                new Main(System.in, "\nRaggio non valido\n") {
                    @Override
                    public boolean run(Scanner scan) throws Exception {
                        range = readValue(scan, "Inserire il raggio: ");
                        return true;
                    }
                }.execute();
            }

            @Override
            public double getApothem() {
                return range;
            }
        }),

        FIGURE(new Shape() {
            private int sideNumber;
            private double side;
            private double aphotem;
            private double fixedNumber = 0;
            @Override
            public double getArea() {
                return getPerimeter()*aphotem/2;
            }

            @Override
            public double getPerimeter() {
                return side*sideNumber;
            }

            @Override
            public void getInfo(Scanner scan) {
                new Main(System.in, "\nValore non valido!\n") {
                    @Override
                    public boolean run(Scanner scan) throws Exception {
                        System.out.print("Inserire il numero di lati: ");
                        sideNumber = scan.nextInt();
                        if(sideNumber <= 0)
                            throw new Exception();
                        side = readValue(scan, "Inserire il lato: ");
                        aphotem = getApothem();
                        return true;
                    }
                }.execute();
            }

            @Override
            public double getApothem() {
                try{
                    fixedNumber = fixedNumbers[sideNumber-3];
                } catch (ArrayIndexOutOfBoundsException e){
                    if(fixedNumber == 0)
                        fixedNumber = readValue(new Scanner(System.in), "Inserire il numero fisso: ");
                } finally {
                    return fixedNumber*side;
                }
            }
        });


        private static final double[] fixedNumbers = {0.289,0.5,0.688,0.866,1.038,1.207,1.374,1.539,1.703,1.866};
        private Shape shape;

        Shapes(Shape s){
            this.shape = s;
        }
        public Shape getShape(){
            return shape;
        }
    }



    public abstract double getVolume();
    public abstract double getLateralArea() throws Exception;
    public abstract double getTotalArea() throws Exception;

    public abstract void scanForInfo(Scanner input) throws Exception;
}