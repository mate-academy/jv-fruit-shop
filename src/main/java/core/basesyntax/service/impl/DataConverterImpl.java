package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            if (line.startsWith("type")) {
                continue;
            }
            String[] parts = line.split(COMMA);
            FruitTransaction.Operation operation = mapToOperation(parts[OPERATION]);
            String fruit = parts[FRUIT_NAME];
            int quantity = Integer.parseInt(parts[QUANTITY]);

            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        }
        return transactions;
    }

    private FruitTransaction.Operation mapToOperation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
