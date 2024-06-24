package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    int MIN_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() < MIN_QUANTITY) {
            throw new RuntimeException("Balance can`t be negative.Actual: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(), transaction.getQuantity());
    }
}
