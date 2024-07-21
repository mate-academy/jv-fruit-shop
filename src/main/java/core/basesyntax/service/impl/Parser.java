package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String HEADER = "type,fruit,quantity";
    private static final String DELIMITER = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    public List<FruitTransaction> parse(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : inputReport) {
            if (line.equals(HEADER)) {
                continue;
            }
            String[] parts = line.split(DELIMITER);
            FruitTransaction.Operation operation = getOperation(parts);
            String fruit = getFruit(parts);
            int quantity = getQuantity(parts);

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperation(String[] parts) {
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[INDEX_OPERATION]);
        if (operation == null) {
            throw new RuntimeException("Invalid operation: " + parts[INDEX_OPERATION]);
        }
        return operation;
    }

    private String getFruit(String[] parts) {
        return parts[INDEX_FRUIT];
    }

    private int getQuantity(String[] parts) {
        int quantity;
        try {
            quantity = Integer.parseInt(parts[INDEX_QUANTITY]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity: " + parts[INDEX_QUANTITY], e);
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be negative: " + quantity);
        }
        return quantity;
    }
}