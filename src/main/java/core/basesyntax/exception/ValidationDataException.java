package core.basesyntax.exception;

import java.io.IOException;

public class ValidationDataException extends RuntimeException {
    public ValidationDataException(String message) {
        super(message);
    }

    public ValidationDataException(String message, IOException e) {
        super(message);
        System.out.println(e.getStackTrace());
    }
}
