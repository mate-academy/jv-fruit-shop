package core.basesyntax.exceptions;

public class IncorrectOperationException extends RuntimeException {
    public IncorrectOperationException(String operationLetter) {
        super("Incorrect operation letter " + operationLetter);
    }
}
