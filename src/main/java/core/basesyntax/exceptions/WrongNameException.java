package core.basesyntax.exceptions;

public class WrongNameException extends IllegalArgumentException {
    private static final String RIGHT_NAME_REGEX = "([a-z]+([-\\\\s]?[a-z]+))";

    public WrongNameException() {
        super("The name must contain only latin letters with spaces or hyphens "
                + "and match "
                + RIGHT_NAME_REGEX
                + " regex");
    }
}
