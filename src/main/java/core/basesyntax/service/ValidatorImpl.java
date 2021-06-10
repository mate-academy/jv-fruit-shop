package core.basesyntax.service;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String PATTERN = "\\w,\\w+,\\d+";

    @Override
    public void validate(List<String> list) {
        for (String record: list) {
            record = record.trim();
            if (!Pattern.matches(PATTERN, record)) {
                throw new RuntimeException("Wrong input format " + record);
            }
        }
    }
}
