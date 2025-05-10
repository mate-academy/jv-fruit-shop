package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = ONE; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(SEPARATOR);
            validateLineFormat(parts, i, line);

            try {
                Operation operation = getOperation(parts[ZERO], i);
                String fruit = getFruit(parts[ONE], i, line);
                int quantity = getQuantity(parts[TWO], i, line);

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (Exception e) {
                throw new IllegalArgumentException("Error processing line "
                        + (i + ONE) + ": " + line, e);
            }
        }

        return transactions;
    }

    private void validateLineFormat(String[] parts, int lineNumber, String line) {
        if (parts.length < THREE) {
            throw new IllegalArgumentException("Invalid data format at line "
                    + (lineNumber + ONE) + ": " + line);
        }
    }

    private Operation getOperation(String operationCode, int lineNumber) {
        Operation operation = Operation.getByCode(operationCode.trim());
        if (operation == null) {
            throw new IllegalArgumentException("Invalid operation code at line "
                    + (lineNumber + ONE) + ": " + operationCode.trim());
        }
        return operation;
    }

    private String getFruit(String fruit, int lineNumber, String line) {
        fruit = fruit.trim();
        if (fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit cannot be empty at line "
                    + (lineNumber + ONE) + ": " + line);
        }
        return fruit;
    }

    private int getQuantity(String quantityStr, int lineNumber, String line) {
        try {
            int quantity = Integer.parseInt(quantityStr.trim());
            if (quantity < ZERO) {
                throw new IllegalArgumentException("Quantity must be non-negative at line "
                        + (lineNumber + ONE) + ": " + line);
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity at line "
                    + (lineNumber + ONE) + ": " + line, e);
        }
    }
}
