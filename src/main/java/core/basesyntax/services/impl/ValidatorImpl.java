package core.basesyntax.services.impl;

import core.basesyntax.exceptions.ValidatorException;
import core.basesyntax.services.Validator;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String INPUT_TITLE = "type,fruit,quantity";
    private static final String PATTERN_LINE = "[bprs],[a-z]*,[0-9]*";

    @Override
    public void validate(List<String> lines) {
        if (lines.isEmpty()) {
            throw new ValidatorException("File is empty, please try another one");
        }
        for (String str : lines) {
            if (!Pattern.matches(PATTERN_LINE, str) && !str.equals(INPUT_TITLE)) {
                throw new ValidatorException("Invalid input data, try again");
            }
        }
    }
}
