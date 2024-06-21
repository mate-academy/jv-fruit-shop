package core.basesyntax.service.impl;

import core.basesyntax.errors.ErrorMessages;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        validateInputReport(inputReport);
        return inputReport.stream()
                .map(this::splitInputString)
                .map(this::createFruitTransaction)
                .toList();
    }

    private void validateInputReport(List<String> inputReport) {
        if (inputReport == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_INPUT_REPORT);
        }
    }

    private String[] splitInputString(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_INPUT_STRING);
        }
        return input.split(",");
    }

    private FruitTransaction createFruitTransaction(String[] strings) {
        validateInputArray(strings);
        FruitTransaction.Operation operation = getOperation(strings[INDEX_OPERATION]);
        String fruit = getFruitName(strings[INDEX_FRUIT]);
        int quantity = getQuantity(strings[INDEX_QUANTITY]);
        validateQuantity(quantity);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private void validateInputArray(String[] strings) {
        if (strings.length < 3) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
        }
    }

    private FruitTransaction.Operation getOperation(String operation) {
        try {
            return FruitTransaction.Operation.of(operation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String getFruitName(String fruit) {
        if (fruit != null && !fruit.isEmpty()) {
            return fruit;
        }
        throw new IllegalArgumentException(ErrorMessages.FRUIT_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }

    private int getQuantity(String quantityString) {
        try {
            return Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_QUANTITY + quantityString);
        }
    }

    private static void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_QUANTITY + quantity);
        }
    }
}
