package core.service.validator;

import core.model.MyConstants;
import core.model.TypeOperations;

public class ForScannerValidatorImpl implements Validator {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;
    private static final int CORRECT_ARRAY_LENGTH = 3;
    private boolean isValid;

    @Override
    public void valid(String string) {
        isValid = true;
        String[] strings = string.split(MyConstants.COMA_SEPARATOR);
        if (strings.length != CORRECT_ARRAY_LENGTH
                || !(strings[INDEX_TYPE_OPERATION].equals(TypeOperations.B.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.S.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.P.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.R.toString().toLowerCase()))
                || !(strings[INDEX_FRUIT_NAME].equals(MyConstants.BANANA)
                || strings[INDEX_FRUIT_NAME].equals(MyConstants.APPLE))
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
