package io.github.dave5080;

import com.sun.istack.internal.Nullable;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Dave5080
 * An InputHandler is a quick implementable abstract class
 * that manages the inputting of data by the user.. You can always create
 * an anonymous class extending this one where you specify which input do you require.
 */
@SuppressWarnings({"SpellCheckingInspection", "unused", "WeakerAccess"})
public class InputHandler {


    /**
     * Mostly used to read values while implementing an {@link InputHandler}
     * @param scan      is the way used to read input doubles
     * @param request   is the prompt sent to users to requesting an input
     * @param error     is the error message threw back to {@link InputHandler#execute(DataReader)}
     * @return          It returns the read value.
     * @throws IllegalArgumentException It's threw to
     *                                  {@link InputHandler#execute(DataReader)} whenever the input it's not valid
     */
    public static double readValue(Scanner scan, String request, @Nullable String error) throws IllegalArgumentException {
        System.out.print(request);
        double value = scan.nextDouble();
        if(value > 0)
            return value;
        else if(error == null)
            throw new IllegalArgumentException();
        else throw new IllegalArgumentException(error);
    }

    /**
     * Simpler version of {@link #readValue(Scanner, String, String)}, it does not require an error message.
     * @see #readValue(Scanner, String, String)
     */
    public static double readValue(Scanner scan, String request){
        return readValue(scan, request, null);
    }

    private InputStream input;
    private PrintStream error;
    private String errorMessage;

    /**
     * When you create the anonymous class extending this one you'll send
     * 2 important values used during the input phase..
     * @param inputStream This is the {@link InputStream} used to read datas.
     * @param errorStream This is where the error log will be printed.
     * @param errorMessage This {@link String} identifies the default error
     *                     that can come from the inpuit phase.
     */
    protected InputHandler(InputStream inputStream, @Nullable PrintStream errorStream, @Nullable String errorMessage) {
        this.input = inputStream;
        this.error = errorStream;
        this.errorMessage = errorMessage;
    }

    /**
     * This alternative form of the constructor is called whenever
     * the input does not require an error handling.
     * @param inputStream This is the {@link InputStream} used to read datas.
     */
    protected InputHandler(InputStream inputStream){
        this(inputStream, null, null);
    }

    /**
     * This is the access point of the input phase, call this method to instantiate it.
     * @param reader Is the instance containing the {@link DataReader#run(Scanner)} method
     *               called to read data
     */
    public void execute(DataReader reader) {
        /* This method is designed for handling 2 types of error that can occur form the input sentences:
         *
         *  - If the DataReader#run() method returns false we accomplish that the default error occurred.
         *  - To print out errors of any other form the run() method'll throw back any kind of Exception
         */
        for (boolean done = false; !done; ) {
            try {
                //Thread.sleep(20);
                if (!(done = reader.run(new Scanner(input))) && error != null)
                    error.println(errorMessage);
            } catch (Exception e) {
                done = false;
                if(error != null)
                    error.println(e.getMessage());
            }
        }
    }
}
