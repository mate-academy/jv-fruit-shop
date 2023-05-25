package core.basesyntax.exeptions;

public class WrongExtensionFile extends RuntimeException {
    public WrongExtensionFile(String message) {
        super(message);
    }
}
