package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }

        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(SEPARATOR);
            if (parts.length != 3) {
                throw new RuntimeException("Invalid CSV format at line: " + line);
            }

            String operationCode = parts[0];
            String fruit = parts[1];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format at line: " + line, e);
            }

            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative: " + line);
            }

            Operation operation = Operation.fromCode(operationCode);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
