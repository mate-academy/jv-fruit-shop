package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    private static final int MINIMUM_QUANTITY = 0;

    @Override
    public void applyOperation(FruitTransaction transaction) {
        if (transaction.getQuantity() < MINIMUM_QUANTITY) {
            throw new RuntimeException("Balance can`t be negative.Actual: "
                    + transaction.getQuantity());
        }
        Storage.updateDb(transaction.getFruitName(), transaction.getQuantity());
    }
}
