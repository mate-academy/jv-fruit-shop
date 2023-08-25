package operations.impl;

import db.Storage;
import model.FruitTransaction;
import operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        int balance = Storage.getFruitBalance(fruitTransaction.getFruitName());
    }
}
