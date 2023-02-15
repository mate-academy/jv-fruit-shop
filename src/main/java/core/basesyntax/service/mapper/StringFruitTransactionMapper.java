package core.basesyntax.service.mapper;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Function;

public class StringFruitTransactionMapper implements Function<String, FruitTransaction> {
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int FRUIT_TYPE_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public FruitTransaction apply(String s) {
        String[] recordParts = s.split(CSV_SEPARATOR);
        String operationSymbol = recordParts[OPERATION_TYPE_COLUMN];
        FruitTransaction.Operation operation = null;
        for (FruitTransaction.Operation value : FruitTransaction.Operation.values()) {
            if (value.getOperationSymbol().equals(operationSymbol)) {
                operation = value;
            }
        }
        if (operation == null) {
            throw new RuntimeException("Invalid operation symbol: " + operationSymbol);
        }
        String fruit = recordParts[FRUIT_TYPE_COLUMN];
        int quantity = Integer.parseInt(recordParts[QUANTITY_COLUMN]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
