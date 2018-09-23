package io.github.dave5080;

import io.github.dave5080.figure.IAbstractSolid;
import io.github.dave5080.figure.figures3D.Solid;
import io.github.dave5080.figure.figures3D.Sphere;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The main class of this example program. Will just implement all of
 * the stuff by using {@link System#in} and {@link System#err} streams
 *
 * This is just an example of how to implement everything.
 */
public class Main {

    /**
     * The main inputHandler passed through almost all the program
     */
    private static InputHandler inputHandler;

    /**
     * @return {@link #inputHandler}
     */
    public static InputHandler getInputHandler(){
        return inputHandler;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String... args) {
        inputHandler = new InputHandler(System.in, System.err, "Valore non valido!");
        boolean repeat;
        do {
            inputHandler.execute(scan -> {
                Arrays.asList(Solid.values()).forEach(solid -> System.out.printf("%s ", solid.name()));
                System.out.print("\nInserire il solido desiderato: ");
                IAbstractSolid figure = Solid.valueOf(scan.nextLine().toUpperCase()).getSolid();
                if (figure != null) {
                    inputHandler.execute(figure);
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
            });
            System.out.println("Continuare col calcolo di un altro solido? \n" +
                    " Premere invio per continuare, digitare exit per terminare.. ");
            repeat = !new Scanner(System.in).nextLine().equals("exit");
        } while(repeat);
    }

}
