package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    private static final String LINE_MATCHER_REGEX = "[bspr],\\w+,\\d+";

    @Override
    public boolean validate(String line) {
        return line.matches(LINE_MATCHER_REGEX);
    }
}
