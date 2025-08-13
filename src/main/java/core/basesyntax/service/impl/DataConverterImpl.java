package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final String DELIMITER = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (data == null || data.isEmpty()) {
            return transactions;
        }

        for (int i = 1;i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(DELIMITER);
            if (parts.length != 3) {
                continue;
            }
            try {
                FruitTransaction.Operation operation = FruitTransaction
                        .Operation.fromCode(parts[INDEX_OPERATION]);
                String fruit = parts[INDEX_FRUIT];
                int quantity = Integer.parseInt(parts[INDEX_QUANTITY]);
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse line: " + line, e);
            }
        }
        return transactions;
    }
}
