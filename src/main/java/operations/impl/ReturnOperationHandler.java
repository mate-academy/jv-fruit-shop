package operations.impl;

import db.Storage;
import model.FruitTransaction;
import operations.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        Storage.addFruits(fruit, Storage.getFruitBalance(fruit) + fruitTransaction.getQuantity());
    }
}
