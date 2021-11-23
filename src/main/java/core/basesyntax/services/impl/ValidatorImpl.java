package core.basesyntax.services.impl;

import core.basesyntax.exceptions.LineParseException;
import core.basesyntax.services.Validator;

public class ValidatorImpl implements Validator {
    private static final String VALID_LINE_PATTERN = "[a-z],\\w+,\\d+";

    @Override
    public void validate(String line) throws RuntimeException {
        if (!line.matches(VALID_LINE_PATTERN)) {
            throw new LineParseException("Line \"" + line + "\" cannot be parsed.");
        }
    }
}
