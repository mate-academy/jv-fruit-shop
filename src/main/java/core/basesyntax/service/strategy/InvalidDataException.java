package core.basesyntax.service.strategy;

public class InvalidDataException extends RuntimeException {
    private String message;

    public InvalidDataException(String message) {
        this.message = message;
    }
}
