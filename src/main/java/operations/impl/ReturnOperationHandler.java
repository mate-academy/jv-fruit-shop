package operations.impl;

import db.Storage;
import model.FruitTransaction;
import operations.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int quantity = fruitTransaction.getQuantity();
        int newBalance = storage.getFruitBalance(fruit) + quantity;
        storage.addFruits(fruit, newBalance);
    }
}
