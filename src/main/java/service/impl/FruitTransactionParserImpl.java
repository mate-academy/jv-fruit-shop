package service.impl;

import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public FruitTransaction parse(String line) {
        String[] parts = line.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
        String fruit = parts[1];
        int quantity = Integer.parseInt(parts[2]);

        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(operation);
        transaction.setFruit(fruit);
        transaction.setQuantity(quantity);
        return transaction;
    }
}
