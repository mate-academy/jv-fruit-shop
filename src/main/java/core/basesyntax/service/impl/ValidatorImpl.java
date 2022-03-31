package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String FILE_TITLE = "type,fruit,quantity";
    private static final String DATA_PATTERN = "[bprs],[a-z]*,[0-9]*";

    @Override
    public void validate(List<String> data) {
        if (data.isEmpty()) {
            throw new RuntimeException("Input file is empty");
        }
        for (String line : data) {
            if (!Pattern.matches(DATA_PATTERN, line) && !line.equals(FILE_TITLE)) {
                throw new RuntimeException("Invalid input data");
            }
        }
    }
}
