package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {
    private static final int BORDER_POSITIVE = 0;

    @Override
    public void processTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < BORDER_POSITIVE) {
            throw new RuntimeException("Balance can't be negative quantity!");
        }
        Storage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
