package core.basesyntax.service;

public class CantReadFileWithThisNameException extends RuntimeException{
    public CantReadFileWithThisNameException(String message) {
        super(message);
    }
}
