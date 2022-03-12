package core.basesyntax.exceptions;

public class WrongNameException extends IllegalArgumentException {
    public WrongNameException() {
        super("The name must contain only latin letters with spaces or hyphens "
                + "and match ([a-z]+([-\\\\s]?[a-z]+)) regex");
    }
}
