package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidator;
import java.util.regex.Pattern;

public class DataValidatorImpl implements DataValidator {
    private static final String LINE_FORMAT = "[bpsr],[a-z]+,[0-9]+";

    @Override
    public boolean validate(String information) {
        if (Pattern.matches(LINE_FORMAT, information)) {
            return true;
        }
        throw new RuntimeException("Input information is not valid");
    }
}
