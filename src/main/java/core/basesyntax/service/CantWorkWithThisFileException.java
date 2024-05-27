package core.basesyntax.service;

public class CantWorkWithThisFileException extends RuntimeException {
    public CantWorkWithThisFileException(String message) {
        super(message);
    }
}
