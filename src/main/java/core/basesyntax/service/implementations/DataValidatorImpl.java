package core.basesyntax.service.implementations;

import core.basesyntax.service.DataValidator;

public class DataValidatorImpl implements DataValidator {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    @Override
    public void validate(String[] data) {
        if (data.length != 3) {
            throw new IllegalArgumentException("Wrong data in input file");
        }

        if (data[OPERATION_INDEX] == null
                || data[FRUIT_INDEX] == null || data[AMOUNT_INDEX] == null) {
            throw new IllegalArgumentException("Wrong data in input file");
        }

        if (data[OPERATION_INDEX].trim().length() != 1) {
            throw new IllegalArgumentException("Invalid operation code in input file");
        }

        if (!isValidString(data[FRUIT_INDEX])) {
            throw new IllegalArgumentException("Invalid fruit name in input file");
        }

        if (!isValidInteger(data[AMOUNT_INDEX])) {
            throw new IllegalArgumentException("Invalid amount value in input file");
        }
    }

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    private boolean isValidInteger(String str) {
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
