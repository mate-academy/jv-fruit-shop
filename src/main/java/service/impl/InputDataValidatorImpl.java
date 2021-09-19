package service.impl;

import service.InputDataValidator;

import java.util.List;

public class InputDataValidatorImpl implements InputDataValidator {
    private static final String VALID_FORMAT = "[sprb],[a-zA-Z]+,[0-9]+";
    @Override
    public void chekDate(List<String> str) {
        for (int i = 1; i < str.size(); i++) {
            if (!str.get(i).matches(VALID_FORMAT)) {
                throw new RuntimeException("Input data is wrong!");
            }
        }
    }
}
