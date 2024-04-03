package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class TransactionParser {
    private static final String DELIMITER = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public static FruitTransaction parseTransaction(String line) {
        String[] parts = line.split(DELIMITER);
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromCode(parts[TYPE_INDEX]);
        String fruit = parts[FRUIT_INDEX];
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
        return new FruitTransaction(operation,fruit,quantity);
    }

}
