package io.github.dave5080;

import java.io.InputStream;
import java.util.Scanner;

public interface DataReader{

    /**
     *
     * @param scan Simple {@link Scanner} built form the {@link InputStream} passed though the {@link InputHandler#InputHandler(InputStream)}
     *             constructor called by the subclasses to read inputs easier.
     * @return When this method returns false it'll be printed {@link InputHandler#errorMessage}
     * @throws Exception It's threw whenever the input phase need to print a different error message.
     */
    boolean run(Scanner scan) throws Exception;
}
