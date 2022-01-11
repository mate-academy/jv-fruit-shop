package validation;

public class RecordValidatorImpl implements RecordValidator {
    private static final int REQUIRED_ARRAY_LENGTH = 3;
    private static final int ACTIVITY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int ACTIVITY_CHARS_LENGTH = 1;
    private static final int ACTIVITY_CHAR_INDEX = 0;
    private static final String DIGITS_CHECK_REGEX = ".*\\d+.*";

    @Override
    public boolean isValidInput(String[] input) {
        if (input.length != REQUIRED_ARRAY_LENGTH) {
            throw new RuntimeException("Input must consist of three parameters");
        }
        String activityType = input[ACTIVITY_INDEX];
        String fruitName = input[FRUIT_INDEX];
        if (activityType.isEmpty()) {
            throw new RuntimeException("Activity type can't be empty!");
        }
        if (activityType.length() != ACTIVITY_CHARS_LENGTH
                || !Character.isLetter(activityType.charAt(ACTIVITY_CHAR_INDEX))) {
            throw new RuntimeException("Activity type has to be a single letter!");
        }
        if (fruitName.isEmpty()) {
            throw new RuntimeException("FruitName can't be empty!");
        }
        if (fruitName.matches(DIGITS_CHECK_REGEX)) {
            throw new RuntimeException("FruitName can't contain digits!");
        }
        int amount = Integer.parseInt(input[AMOUNT_INDEX]);
        if (amount < 0) {
            throw new RuntimeException("Amount can't be less than zero!");
        }
        return true;
    }
}
