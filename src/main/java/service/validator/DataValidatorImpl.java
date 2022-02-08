package service.validator;

import exception.ValidationException;

public class DataValidatorImpl implements DataValidator<String> {
    private static final int VALUE_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public void validate(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("File is empty. String value is null");
        }
        String[] data = value.split(CSV_SEPARATOR);
        if (data.length != 3) {
            throw new ValidationException("Incorrect data. Value: " + value);
        }
        if (Integer.parseInt(data[VALUE_INDEX]) < 0) {
            throw new ValidationException("Value could not be less than 0");
        }
    }
}
