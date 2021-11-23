package service.impl;

import service.Validator;

public class ValidatorImpl implements Validator {
    private static final String ACTIONS = "b s p r";
    private static final int EXPECTED_LENGTH = 3;
    private static final int FIRST_INDEX = 0;
    private static final int THIRD_INDEX = 2;

    @Override
    public void validate(String[] fruit) {
        if (fruit.length != EXPECTED_LENGTH || !ACTIONS.contains(fruit[FIRST_INDEX])
                || Integer.parseInt(fruit[THIRD_INDEX]) <= 0) {
            throw new RuntimeException("Unreadable data");
        }
    }
}

