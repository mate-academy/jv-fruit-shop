package core.basesyntax.exceptions;

public class NoExistFruitInStorageException extends RuntimeException {
    public NoExistFruitInStorageException(String value) {
        super("Fruit: " + value + " does not exist in Storage.");
    }
}
