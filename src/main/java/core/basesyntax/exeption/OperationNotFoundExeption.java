package core.basesyntax.exeption;

public class OperationNotFoundExeption extends RuntimeException {
    public OperationNotFoundExeption(String message) {
        super(message);
    }
}
