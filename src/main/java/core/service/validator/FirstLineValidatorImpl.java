package core.service.validator;

import core.model.MyConstants;

public class FirstLineValidatorImpl implements Validator {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    @Override
    public void valid(String string) {
        String[] strings = string.split(MyConstants.COMA_SEPARATOR);
        if (!(strings.length == 3
                && strings[INDEX_TYPE_OPERATION].equals(MyConstants.TYPE)
                && strings[INDEX_FRUIT_NAME].equals(MyConstants.FRUIT)
                && strings[INDEX_FRUIT_QUANTITY].equals(MyConstants.QUANTITY))) {
            throw new RuntimeException("Title in reading file is incorrect!");
        }
    }
}
