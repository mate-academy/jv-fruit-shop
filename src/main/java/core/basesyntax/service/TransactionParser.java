package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class TransactionParser {
    public static FruitTransaction parseTransaction(String line) {
        String[] parts = line.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
        String fruit = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        return FruitTransaction.of(operation,fruit,quantity);
    }

}
