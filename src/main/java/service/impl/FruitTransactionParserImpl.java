package service.impl;

import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {

    @Override
    public FruitTransaction parse(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Input line cannot be null or empty");
        }

        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }

        FruitTransaction.Operation operation;
        try {
            operation = FruitTransaction.Operation.fromCode(parts[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation code: " + parts[0], e);
        }

        String fruit = parts[1];
        int quantity;
        try {
            quantity = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity value: " + parts[2], e);
        }

        return new FruitTransaction(operation, fruit, quantity);
    }
}
