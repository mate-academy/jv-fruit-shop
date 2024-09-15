package strategy.activities;

import db.Storage;
import db.StorageImpl;
import model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private static final int PRIMARY_QUANTITY = 0;
    private static final Storage storage = new StorageImpl();

    @Override
    public void executeTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        if (transaction.getQuantity() < PRIMARY_QUANTITY) {
            throw new RuntimeException("Balance is negative!");
        }
        Integer currentValue = storage.getValue(fruit);
        storage.setValue(fruit, currentValue - quantity);
    }
}
