package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.service.interfaces.TransactionValidator;

public class TransactionValidatorImpl implements TransactionValidator {
    @Override
    public void validate(String data) {
        checkIfNull(data);
        checkIfEmpty(data);
        checkIfCorrectFormat(data);
    }

    private void checkIfNull(String data) {
        if (data == null) {
            throw new InvalidDataException("The input data must not be null!");
        }
    }

    private void checkIfEmpty(String data) {
        if (data.length() == 0) {
            throw new InvalidDataException("The input data must not be empty!");
        }
    }

    private void checkIfCorrectFormat(String data) {
        String regex = "[bspr],\\w+,([1-9][0-9]{0,3})$";
        data = data.trim();
        if (!data.matches(regex)) {
            throw new InvalidDataException("The record doesn't have required format!");
        }
    }
}
