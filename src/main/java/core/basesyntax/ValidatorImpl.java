package core.basesyntax;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    public static final String PATTERN = "[bspr],(banana|apple),\\d+";

    @Override
    public void validate(List<String> list) {
        for (String record: list) {
            if (!Pattern.matches(PATTERN, record)) {
                throw new RuntimeException("Wrong input format" + record);
            }
        }
    }
}
