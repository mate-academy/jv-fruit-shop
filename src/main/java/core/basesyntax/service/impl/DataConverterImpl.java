package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int EXPECTED_PARTS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] data = transaction.split(" ");
            if (data.length != EXPECTED_PARTS) {
                throw new IllegalArgumentException("Invalid transaction format: "
                        + transaction);
            }
            String type = data[0];
            FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(type);
            String fruit = data[1];
            int quantity;
            try {
                quantity = Integer.parseInt(data[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity format: "
                        + data[2]);
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
            }
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}

