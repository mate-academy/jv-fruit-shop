package service.impl;

import java.util.List;
import service.Validator;

public class ValidatorImpl implements Validator {
    private static final String ACTIONS = "bspr";
    private static final int EXPECTED_LENGTH = 3;
    private static final int FIRST_INDEX = 0;
    private static final int THIRD_INDEX = 2;

    @Override
    public void validate(List<String> fruits) {
        if (fruits.get(FIRST_INDEX).equals("type,fruit,quantity")) {
            fruits.remove(FIRST_INDEX);
        }
        for (String fruit : fruits) {
            String[] fruitOptions = fruit.split(",");
            if (fruitOptions.length != EXPECTED_LENGTH
                    || !ACTIONS.contains(fruitOptions[FIRST_INDEX])
                    || Integer.parseInt(fruitOptions[THIRD_INDEX]) <= 0) {
                throw new RuntimeException("Unreadable data");
            }
        }
    }
}

