package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String PATTERN = "[bsrp],[a-z]+,[0-9]+";

    @Override
    public boolean validate(String input) {
        if (Pattern.matches(PATTERN, input)) {
            return true;
        }
        throw new RuntimeException("Unknown input format" + input);
    }
}
