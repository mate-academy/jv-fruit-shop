package core.basesyntax.exceptions;

import java.io.IOException;

public class FileException extends RuntimeException {
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, IOException e) {
        super(message, e);
    }
}
