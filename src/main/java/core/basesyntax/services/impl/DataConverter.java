package core.basesyntax.services.impl;

import core.basesyntax.Constants;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line: lines.subList(1, lines.size())) {
            String[] parts = line.split(Constants.SEPARATOR);
            if (parts.length != 3) {
                throw new RuntimeException("Invalid line (must be split into 3 parts): " + line);
            }
            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.fromCode(parts[0]);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Incorrect operation code: " + parts[0] + " in line: "
                        + line, e);
            }
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
                if (quantity < 0) {
                    throw new RuntimeException("The quantity cannot be negative: "
                            + parts[2] + " in line: " + line);
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity (not number): "
                        + parts[2] + " in line: " + line, e);
            }
            transactions.add(new FruitTransaction(operation,fruit,quantity));
        }
        return transactions;
    }
}
