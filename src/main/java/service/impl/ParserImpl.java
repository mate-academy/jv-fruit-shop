package service.impl;

import model.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser<FruitTransaction> {
    public static final String REGEX_FOR_SPLIT = ",";
    public static final int NUMBER_OF_PARTS = 3;
    public static final int MIN_QUANTITY = 0;

    @Override
    public FruitTransaction parse(String transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction string can't be null");
        }
        String[] parts = transaction.split(REGEX_FOR_SPLIT);
        if (parts.length != NUMBER_OF_PARTS) {
            throw new IllegalArgumentException("Transaction string must have 3 parts: "
                    + "operation, fruit, quantity");
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
        if (operation == null) {
            throw new IllegalArgumentException("Unknown operation code: " + parts[0]);
        }
        String fruit = parts[1];
        if (fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit name can't be empty");
        }
        int quantity;
        try {
            quantity = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quantity must be a valid integer: " + parts[2], e);
        }
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("Quantity can't be less than 0!");
        }
        return new FruitTransaction(operation,fruit,quantity);
    }
}
