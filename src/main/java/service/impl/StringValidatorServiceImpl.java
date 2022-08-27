package service.impl;

import java.util.List;
import service.StringValidatorService;

public class StringValidatorServiceImpl implements StringValidatorService {
    private static final int TITLE_INDEX = 0;
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final int VALID_LENGTH = 3;
    private static final String TITLE_STRING = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String[] TYPE_OF_TRANSACTION = new String[] {"b", "s", "p", "r"};
    private static final String[] TYPE_OF_FRUITS = new String[] {"banana", "apple"};

    @Override
    public boolean isStringValid(List<String> data) {
        if (!data.get(TITLE_INDEX).equals(TITLE_STRING)) {
            return false;
        }
        data.remove(TITLE_INDEX);
        return data.stream().allMatch(this::isStringValid);
    }

    @Override
    public boolean isStringValid(String string) {
        if (string == null) {
            return false;
        }
        String[] elements = string.split(SEPARATOR);
        return emptyLineValidator(string) && amountOfElementsValidator(elements)
                && typeOfTransactionValidator(elements[TYPE])
                && typeOfFruitValidator(elements[FRUIT])
                && amountValidator(elements[AMOUNT]);
    }

    private boolean emptyLineValidator(String string) {
        return string.length() != 0;
    }

    private boolean amountOfElementsValidator(String[] strings) {
        return strings.length == VALID_LENGTH;
    }

    private boolean typeOfTransactionValidator(String type) {
        boolean valid = false;
        for (String typeFromArray : TYPE_OF_TRANSACTION) {
            if (typeFromArray.equals(type)) {
                valid = true;
            }
        }
        return valid;
    }

    private boolean typeOfFruitValidator(String type) {
        boolean valid = false;
        for (String typeFromArray : TYPE_OF_FRUITS) {
            if (typeFromArray.equals(type)) {
                valid = true;
            }
        }
        return valid;
    }

    private boolean amountValidator(String amount) {
        return amount.chars()
                .allMatch(Character::isDigit);
    }
}
