package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        boolean isHeader = true; // Skip the header line
        for (String line : data) {
            if (isHeader) {
                isHeader = false;
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid data format");
            }
            try {
                FruitTransaction.Operation operation = FruitTransaction
                        .Operation.fromCode(parts[0].trim());
                String fruit = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid operation type in data: "
                        + parts[0].trim(), e);
            }
        }
        return transactions;
    }
}
