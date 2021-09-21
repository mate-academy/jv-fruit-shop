package service.validator;

import exception.ValidationException;

public class ValidationDataImpl implements ValidationData<String> {
    @Override
    public void validate(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("File is empty. String value is null");
        }
        String[] data = value.split(",");
        if (data.length != 3) {
            throw new ValidationException("Incorrect data. Value: " + value);
        }
        if (Integer.parseInt(data[2]) < 0) {
            throw new ValidationException("Value could not be less than 0");
        }
    }
}
