package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final String VALID_FORMAT = "[sprb],[a-zA-Z]+,[0-9]+";

    public boolean isLineValid(String string) {
        return string.matches(VALID_FORMAT);
    }
}
