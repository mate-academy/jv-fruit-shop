package core.dao;

import core.exception.ValidationException;

public class ValidatorImpl implements Validator<String> {

    public ValidatorImpl() {
    }

    public void validate(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("FruitOperation has not data. String value is null.");
        }
        String[] data = value.split(",");
        if (data.length != 3) {
            throw new ValidationException("Not enough data: Value: " + value);
        }
        if (Integer.parseInt(data[2]) < 0) {
            throw new ValidationException("Quantity must not be < 0");
        }
    }
}
