package io.github.dave5080;

import java.io.InputStream;
import java.util.Scanner;

public abstract class InputHandler {
    private InputStream input;
    private String errorMessage;

    protected InputHandler(InputStream input, String errorMessage){
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
