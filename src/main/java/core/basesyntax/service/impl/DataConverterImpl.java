package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String LINES_SEPARATOR = ",";
    private static final int OPERATION_PART = 0;
    private static final int FRUIT_TYPE_PART = 1;
    private static final int QUANTITY_PART = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(LINES_SEPARATOR);

            if (parts.length != 3) {
                throw new RuntimeException("Invalid CSV line: '"
                        + line
                        + "'. Expected 3 columns: type,fruit,quantity");
            }

            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.getOperationByCode(parts[OPERATION_PART]);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown operation in line: " + line, e);
            }

            String fruit = parts[FRUIT_TYPE_PART];

            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_PART]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity in line: " + line, e);
            }
            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative: " + line);
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
