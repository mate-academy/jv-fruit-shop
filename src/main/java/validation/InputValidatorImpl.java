package validation;

public class InputValidatorImpl implements InputValidator {
    private static final int REQUIRED_ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int OPERATION_CHARS = 1;
    private static final int OPERATION_CHAR_INDEX = 0;

    @Override
    public boolean isValidInput(String[] input) {
        if (input.length != REQUIRED_ARRAY_LENGTH) {
            throw new RuntimeException("Input must consist of three parameters");
        }
        String operationType = input[OPERATION_INDEX];
        String fruit = input[FRUIT_INDEX];
        int amount = Integer.parseInt(input[AMOUNT_INDEX]);
        if (operationType.isEmpty()) {
            throw new RuntimeException("Operation type can't be empty!");
        }
        if (operationType.length() != OPERATION_CHARS
                || !Character.isLetter(operationType.charAt(OPERATION_CHAR_INDEX))) {
            throw new RuntimeException("Operation type has to be a single letter!");
        }
        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit name can't be empty!");
        }
        if (fruit.matches(".*\\d+.*")) {
            throw new RuntimeException("Fruit name can't contain digits!");
        }
        if (amount < 0) {
            throw new RuntimeException("Fruits amount can't be less than 0");
        }
        return true;
    }
}
