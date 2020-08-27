package core.basesyntax.customexceptions;

public class BadFileFormatting extends RuntimeException {
    public BadFileFormatting(String message) {
        super(message);
    }
}
