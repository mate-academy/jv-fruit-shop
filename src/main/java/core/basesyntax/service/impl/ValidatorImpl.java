package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;

public class ValidatorImpl implements Validator {
    private static final String INPUT_TEXT_FORMAT = "[bspr],[a-z]+,[0-9]+";

    @Override
    public boolean validate(String line) {
        if (line != null && line.matches(INPUT_TEXT_FORMAT)) {
            return true;
        }
        throw new RuntimeException("Incorrect input line: " + line);
    }
}
