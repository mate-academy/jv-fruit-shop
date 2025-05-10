package core.basesyntax.exceptions;

public class NoSuchFruitInStorageException extends InvalidOperationException {

    public NoSuchFruitInStorageException(String message) {
        super(message);
    }
}
