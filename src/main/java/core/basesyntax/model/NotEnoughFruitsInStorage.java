package core.basesyntax.model;

public class NotEnoughFruitsInStorage extends RuntimeException {
    public NotEnoughFruitsInStorage(String message) {
        super(message);
    }
}
