package core.basesyntax.service;

public class ValidatorImpl implements Validator {
    private static final String VALID_FORMAT = "[sprb],[a-zA-Z]+,[0-9]+";

    public boolean isLineValid(String s) {
        return s.matches(VALID_FORMAT);
    }
}
