package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.Mapper;

public class FruitTransactionMapper implements Mapper<FruitTransaction, String> {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction toObject(String string) {
        String[] split = string.split(DELIMITER);
        validateSplitLength(split, string);
        Operation operation = Operation.fromCode(split[OPERATION_INDEX]);
        String fruit = split[FRUIT_INDEX];
        int quantity = parseQuantity(split[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private void validateSplitLength(String[] split, String string) {
        if (split.length != 3) {
            throw new IllegalArgumentException("Input string must contain "
                    + "exactly three elements separated by the delimiter '"
                    + DELIMITER + "', but found " + split.length + ": [" + string + "]");
        }
    }

    private int parseQuantity(String quantityString) {
        int quantity = Integer.parseInt(quantityString);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity = ["
                    + quantity + "], but should be positive");
        }
        return quantity;
    }
}
