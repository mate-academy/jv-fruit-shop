package core.service.validator;

public class FirstLineValidatorImpl implements Validator {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;
    private static final String TYPE = "type";
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public void valid(String string) {
        String[] strings = string.split(COMA_SEPARATOR);
        if (!(strings.length == 3
                && strings[INDEX_TYPE_OPERATION].equals(TYPE)
                && strings[INDEX_FRUIT_NAME].equals(FRUIT)
                && strings[INDEX_FRUIT_QUANTITY].equals(QUANTITY))) {
            throw new RuntimeException("Title in reading file is incorrect!");
        }
    }
}
