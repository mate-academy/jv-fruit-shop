package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    private static final String DELIMITER = ",";
    private static final int REQUIRED_FIELDS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(DELIMITER);
            if (data.length != REQUIRED_FIELDS_COUNT) {
                throw new IllegalArgumentException(
                        "Invalid data format: expected " + REQUIRED_FIELDS_COUNT
                                + " fields, but got " + data.length + ". Line: " + line);
            }

            FruitTransaction.OperationType operation = FruitTransaction.OperationType
                    .fromCode(data[OPERATION_INDEX]);
            String fruit = data[FRUIT_INDEX];

            int quantity;
            try {
                quantity = Integer.parseInt(data[QUANTITY_INDEX]);
                if (quantity < 0) {
                    throw new IllegalArgumentException(
                            "Quantity must be non-negative. Got: " + quantity
                                    + ". Line: " + line);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity format: must be a number. Line: " + line, e);
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
