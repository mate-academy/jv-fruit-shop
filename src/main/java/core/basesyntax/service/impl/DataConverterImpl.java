package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        boolean isFirstLine = true;
        for (String line : rawData) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Incorrect data format in line: " + line);
            }
            try {
                FruitTransaction.Operation operation = FruitTransaction.Operation
                        .fromCode(parts[0].trim());
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                if (quantity < 0) {
                    throw new IllegalArgumentException("Quantity cannot be negative in line: "
                            + line);
                }
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid line: " + line, e);
            }
        }
        return transactions;
    }
}
