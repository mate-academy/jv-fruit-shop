package core.basesyntax.service;

import core.basesyntax.exception.ValidationException;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String INPUT_DATA_HEAD = "type,fruit,quantity";
    private static final String LINE_PATTERN = "[bprs],[a-z]*,[0-9]*";

    @Override
    public boolean validate(List<String> inputData) {
        if (inputData.isEmpty()) {
            throw new ValidationException("input data is empty");
        }
        if (!inputData.contains(INPUT_DATA_HEAD) && !inputData.contains(LINE_PATTERN)) {
            throw new ValidationException("Invalid input data, try again");
        }
        for (String data : inputData) {
            if (!Pattern.matches(LINE_PATTERN, data) && !data.equals(INPUT_DATA_HEAD)) {
                throw new ValidationException("Invalid input data, try again");
            }
        }
        return true;
    }
}
