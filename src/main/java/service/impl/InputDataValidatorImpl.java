package service.impl;

import java.util.List;
import java.util.regex.Pattern;
import service.InputDataValidator;

public class InputDataValidatorImpl implements InputDataValidator {
    private static final Pattern VALID_RECORD = Pattern.compile("[sprb],[a-zA-Z]+,[0-9]+");

    @Override
    public void chekDate(List<String> str) {
        for (int i = 1; i < str.size(); i++) {
            if (!VALID_RECORD.matcher(str.get(i)).matches()) {
                throw new RuntimeException("Input data is wrong!");
            }
        }
    }
}
