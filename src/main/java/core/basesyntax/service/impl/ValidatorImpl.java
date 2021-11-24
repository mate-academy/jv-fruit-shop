package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String LINE_MATCHER_REGEX = "[bprs],[a-z]*,[0-9]*";

    @Override
    public boolean isValid(List<String> inputData) {
        if (inputData.isEmpty()) {
            throw new RuntimeException("File is empty, please try another one");
        }
        for (String str : inputData) {
            if (!Pattern.matches(LINE_MATCHER_REGEX, str) && !str.equals("type,fruit,quantity")) {
                throw new RuntimeException("Invalid input data, try again");
            }
        }
        return true;
    }
}
