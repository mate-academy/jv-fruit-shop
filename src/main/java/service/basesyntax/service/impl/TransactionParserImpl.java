package service.basesyntax.service.impl;

import service.basesyntax.model.FruitTransaction;
import service.basesyntax.service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public FruitTransaction parse(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("line is null or empty");
        }

        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid line format: " + line);
        }

        FruitTransaction fruitTransaction = new FruitTransaction();

        fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(parts[0].trim()));
        fruitTransaction.setFruit(parts[1].trim());

        int quantity = Integer.parseInt(parts[2].trim());
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + quantity);
        }
        fruitTransaction.setQuantity(quantity);

        return fruitTransaction;
    }
}
