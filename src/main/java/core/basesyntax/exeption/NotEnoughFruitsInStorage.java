package core.basesyntax.exeption;

public class NotEnoughFruitsInStorage extends RuntimeException {
    public NotEnoughFruitsInStorage(String message) {
        super(message);
    }
}
