package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int EXPECTED_PARTS_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(",");
            if (parts.length != EXPECTED_PARTS_LENGTH) {
                throw new IllegalArgumentException("Invalid data format: " + line);
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation.getOperationByCode(parts[OPERATION_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity: " + parts[QUANTITY_INDEX]);
            }

            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(operation);
            transaction.setFruit(fruit);
            transaction.setQuantity(quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
