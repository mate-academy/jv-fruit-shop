package core.basesyntax.service.exceptions;

public class UnsupportedActivityException extends RuntimeException{
    public UnsupportedActivityException(String unsuppoertedCode) {
        super("Activity code " + unsuppoertedCode + "doesnt suppert");
    }
}
