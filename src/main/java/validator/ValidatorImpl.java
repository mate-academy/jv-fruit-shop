package validator;

public class ValidatorImpl implements Validator {
    public static final int EXPECTED_ARRAY_LENGTH = 3;
    public static final int FRUIT_VALUE_INDEX = 2;

    @Override
    public void validate(String[] array) {
        if (array.length != EXPECTED_ARRAY_LENGTH) {
            throw new RuntimeException("Invalid data " + array);
        }
        if (Integer.parseInt(array[FRUIT_VALUE_INDEX]) < 0) {
            throw new RuntimeException("value is less than zero " + array[FRUIT_VALUE_INDEX]);
        }
    }
}
