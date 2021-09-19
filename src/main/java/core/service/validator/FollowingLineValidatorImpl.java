package core.service.validator;

import core.model.MyConstants;
import core.model.TypeOperations;

public class FollowingLineValidatorImpl implements Validator {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    @Override
    public void valid(String string) {
        String[] strings = string.split(MyConstants.COMA_SEPARATOR);
        if (strings.length != 3
                && (strings[INDEX_TYPE_OPERATION].equals(TypeOperations.B.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.S.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.P.toString().toLowerCase())
                || strings[INDEX_TYPE_OPERATION].equals(TypeOperations.R.toString().toLowerCase()))
                && (strings[INDEX_FRUIT_NAME].equals(MyConstants.BANANA)
                || strings[INDEX_FRUIT_NAME].equals(MyConstants.APPLE))
                && Integer.parseInt(strings[INDEX_FRUIT_QUANTITY]) > 0) {
            throw new RuntimeException("Line in reading file is incorrect!");
        }
    }
}
