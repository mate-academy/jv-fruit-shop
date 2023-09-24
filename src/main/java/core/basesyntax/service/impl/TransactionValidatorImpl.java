package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitShopOperation;
import core.basesyntax.service.interfaces.TransactionValidator;
import java.util.Arrays;
import java.util.function.Predicate;

public class TransactionValidatorImpl implements TransactionValidator {
    private static final String RECORD_PATTERN = "[bspr],\\w+,([1-9][0-9]{0,3})$";
    private static final int INDEX_OF_OPERATION_IN_RECORD = 0;
    private static final int INDEX_OF_QUANTITY_IN_RECORD = 2;

    @Override
    public void validate(String data) {
        checkIfNull(data);
        checkIfEmpty(data);
        checkIfCorrectFormat(data);
        checkOperationName(data);
        checkQuantity(data);
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
        String regex = RECORD_PATTERN;
        data = data.trim();
        if (!data.matches(regex)) {
            throw new InvalidDataException("The record doesn't have required format!");
        }
    }

    private void checkOperationName(String data) {
        Predicate<FruitShopOperation> predicate = element -> element.equals(
                FruitShopOperation.fromCode(
                        splittedData(data)[INDEX_OF_OPERATION_IN_RECORD].trim()));
        if (Arrays.stream(FruitShopOperation.values()).noneMatch(predicate)) {
            throw new InvalidDataException("The FruitShopOperation is not valid!");
        }
    }

    private void checkQuantity(String data) {
        if (Integer.parseInt(splittedData(data)[INDEX_OF_QUANTITY_IN_RECORD]) <= 0) {
            throw new InvalidDataException("Quantity is not valid! It has to be greater than 0!");
        }
    }

    private String[] splittedData(String data) {
        return data.split(",");
    }
}
