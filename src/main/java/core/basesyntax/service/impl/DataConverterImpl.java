package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Malformed line at "
                        + (i + 1) + ": " + line);
            }
            String type = parts[0].trim();
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity at line "
                        + (i + 1) + ": " + line);
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("Negative quantity not allowed at line "
                        + (i + 1) + ": " + line);
            }
            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.fromCode(type);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Unknown operation type at line "
                        + (i + 1) + ": " + line);
            }
            String fruit = parts[1].trim();
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
