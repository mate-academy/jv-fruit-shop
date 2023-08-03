package operations.impl;

import db.Storage;
import model.FruitTransaction;
import operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int balance = storage.getFruitBalance(fruit);
    }
}
