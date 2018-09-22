package io.github.dave5080;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Dave5080
 * An InputHandler is a quick implementable abstract class
 * that manages the inputting of data by the user.. You can always create
 * an anonymous class extending this one where you specify which input do you require.
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class InputHandler {
    private InputStream input;
    private PrintStream error;
    private String errorMessage;

    /**
     * When you create the anonymous class extending this one you'll send
     * 2 important values used during the input phase..
     * @param inputStream This is the InputStream used to read datas.
     * @param errorStream This is where the error log will be printed.
     * @param errorMessage This String identifies the default error
     *                     that can come from the inpuit phase.
     */
    protected InputHandler(InputStream inputStream, PrintStream errorStream, String errorMessage) {
        this.input = inputStream;
        this.error = errorStream;
        this.errorMessage = errorMessage;
    }

    /**
     * This alternative form of the constructor is called whenever
     * the input does not require an error handling.
     * @param inputStream This is the InputStream used to read datas.
     */
    protected InputHandler(InputStream inputStream){
        this(inputStream, null, null);
    }

    /**
     * This is the access point of the input phase, call this method to instantiate it.
     */
    public void execute() {
        /* This method is designed for handling 2 types of error that can occur form the input sentences:
         *
         *  - If the run() method returns false we accomplish that the default error occurred.
         *  - To print out errors of any other form the run() method'll throw back any kind of Exception
         */
        for (boolean done = false; !done; ) {
            try {
                //Thread.sleep(20);
                if (!(done = run(new Scanner(input))) && error != null)
                    error.println(errorMessage);
            } catch (Exception e) {
                done = false;
                if(error != null)
                    error.println(e.getMessage());
            }
        }
    }

    /**
     *
     * @param scan Simple scanner built form the inputStream passed though the constructor
     *             used in the subclasses to read inputs easier.
     * @return When this method returns false it'll be printed the default error message.
     * @throws Exception It's threw whenever the input phase need to print a different error message.
     */
    protected abstract boolean run(Scanner scan) throws Exception;
}
