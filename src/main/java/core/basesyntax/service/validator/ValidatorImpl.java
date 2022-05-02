package core.basesyntax.service.validator;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final String COLUMNS = "type,fruit,quantity";
    private static final String VALID_PATTERN = "[bspr],\\w+,\\d+";

    @Override
    public boolean validate(List<String> data) {
        for (String string : data) {
            if (!Pattern.matches(VALID_PATTERN, string) && !string.equals(COLUMNS)) {
                throw new RuntimeException("Invalid input data");
            }
        }
        return true;
    }
}
