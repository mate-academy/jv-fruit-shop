package core.basesyntax.service.exceptions;

public class UnsupportedFruitActivityException extends RuntimeException {
    public UnsupportedFruitActivityException(String unsuppoertedCode) {
        super("Activity code " + unsuppoertedCode + "doesnt suppert");
    }
}
