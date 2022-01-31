package core.service.validator;

import core.model.TypeOperations;

public class ForScannerValidatorImpl implements Validator {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;
    private static final int CORRECT_ARRAY_LENGTH = 3;
    private static final String COMA_SEPARATOR = ",";
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private boolean isValid;

    @Override
    public void valid(String string) {
        isValid = true;
        String[] strings = string.split(COMA_SEPARATOR);
        if (strings.length != CORRECT_ARRAY_LENGTH
                || !(strings[INDEX_TYPE_OPERATION].equals(TypeOperations.BALANCE.get())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.SUPPLY.get())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.PURCHASE.get())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.RETURN.get()))
                || !(strings[INDEX_FRUIT_NAME].equals(BANANA)
                || strings[INDEX_FRUIT_NAME].equals(APPLE))
                || Integer.parseInt(strings[INDEX_FRUIT_QUANTITY]) <= 0) {
            System.out.println("Не коректний данні!");
            isValid = false;
        }
    }

    public boolean checkIsValid(String string) {
        valid(string);
        return isValid;
    }
}
