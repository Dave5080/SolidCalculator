package io.github.dave5080;

import io.github.dave5080.figure.AbstractFigure;
import io.github.dave5080.figure.Sphere;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Main {

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String... args) {

        boolean repeat;
        do {
            new Main(System.in, "\nValore non valido!\n") {
                @Override
                public boolean run(Scanner scan) throws Exception {
                    Arrays.asList(AbstractFigure.Solid.values()).forEach(solid -> System.out.printf("%s ", solid.name()));
                    System.out.print("\nInserire il solido desiderato: ");
                    AbstractFigure figure = AbstractFigure.Solid.valueOf(scan.nextLine().toUpperCase()).getSolid();
                    if (figure != null) {
                        figure.scanForInfo(scan);
                        if (figure instanceof Sphere)
                            System.out.printf("%nSuperficie: %s%nVolume: %s%n%n",
                                    figure.getTotalArea(),
                                    figure.getVolume());
                        else
                            System.out.printf("%nSuperficie laterale: %s%nSuperficie totale: %s%nVolume: %s%n%n",
                                    figure.getLateralArea(),
                                    figure.getTotalArea(),
                                    figure.getVolume());
                        return true;
                    }
                    return false;
                }
            }.execute();
            System.out.println("Continuare col calcolo di un altro solido? \n" +
                    " Premere invio per continuare, digitare exit per terminare.. ");
            repeat = !new Scanner(System.in).nextLine().equals("exit");
        } while(repeat);
    }


    private InputStream input;
    private String errorMessage;

    public Main(InputStream input, String errorMessage){
        this.input = input;
        this.errorMessage = errorMessage;
    }

    public void execute(){

            for(boolean done = false; !done;) {
                try{
                    Thread.sleep(20);
                    if(!(done = run(new Scanner(input))))
                        System.err.println(errorMessage);
                } catch (Exception e){
                    done = false;
                    System.err.println(errorMessage);
                }
            }
    }

    public abstract boolean run(Scanner scan) throws Exception;
}
