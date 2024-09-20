package core.basesyntax.service;

import core.basesyntax.model.Transaction;

public class TransactionParser {
    public Transaction parseLine(String line) {
        String[] parts = line.split(",");
        String operation = parts[0];
        String fruitName = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        return new Transaction(operation, fruitName, quantity);
    }
}
