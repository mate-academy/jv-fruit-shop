package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void transaction(String fruit, int quantity) {
        int oldValue = Storage.STORAGE.get(fruit);
        int newValue = oldValue - quantity;
        if (newValue < 0) {
            throw new RuntimeException("Balance is negative " + fruit + " " + newValue);
        }
        Storage.STORAGE.put(fruit, newValue);
    }
}
