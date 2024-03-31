package core.basesyntax.exception;

import java.io.IOException;

public class ReadFromFileCsvException extends RuntimeException {
    public ReadFromFileCsvException(String message, Throwable cause) {
        super(message, cause);
    }
}
