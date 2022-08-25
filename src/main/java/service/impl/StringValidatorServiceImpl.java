package service.impl;

import java.util.List;
import service.StringValidatorService;

public class StringValidatorServiceImpl implements StringValidatorService {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final String TITLE = "type,fruit,quantity";
    private static final String[] TYPE_OF_TRANSACTION = new String[] {"b", "s", "p", "r"};
    private static final String[] TYPE_OF_FRUITS = new String[] {"banana", "apple"};

    @Override
    public boolean isStringValid(List<String> data) {
        if (!isStringValid(data.get(0))) {
            data.remove(0);
        }
        return data.stream().allMatch(this::isStringValid);
    }

    @Override
    public boolean isStringValid(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        String[] strings = string.split(SEPARATOR);
        if (strings.length != 3) {
            return false;
        }
        boolean valid = false;
        for (String typeOfTransaction : TYPE_OF_TRANSACTION) {
            if (strings[TYPE].equals(typeOfTransaction)) {
                valid = true;
            }
        }
        if (!valid) {
            return false;
        }
        valid = false;
        for (String typeOfFruit : TYPE_OF_FRUITS) {
            if (strings[FRUIT].equals(typeOfFruit)) {
                valid = true;
            }
        }
        if (!valid) {
            return false;
        }
        return strings[AMOUNT].chars().allMatch(Character::isDigit);
    }
}
