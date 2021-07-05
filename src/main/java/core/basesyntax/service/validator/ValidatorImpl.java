package core.basesyntax.service.validator;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(List<String> list) {
        for (String record : list) {
            record = record.trim();
            if (!Pattern.matches("\\w,\\w+,\\d+", record)) {
                throw new RuntimeException("Wrong input format " + record);
            }
            int value = Integer.parseInt(record.split(",")[2]);
            if (value < 0) {
                throw new RuntimeException("Wrong input value " + record);
            }
        }
    }
}
