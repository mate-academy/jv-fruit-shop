package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String LINE_FORMAT = "[bpsr],[a-z]+,[0-9]+";

    @Override
    public boolean validate(String information) {
        if (Pattern.matches(LINE_FORMAT, information)) {
            return true;
        }
        throw new RuntimeException("Invalid input data");
    }
}
