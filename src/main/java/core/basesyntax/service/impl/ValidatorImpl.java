package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String PATTERN = "[bsrp],[a-z]+,[0-9]+";

    @Override
    public void validate(String string) {
        if (!Pattern.matches(PATTERN, string)) {
            throw new RuntimeException("Wrong input format " + string);
        }
    }
}
