package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void doOperation(String fruit, int numbers) {
        int newNumbers = Storage.storageMap.get(fruit) - numbers;
        if (newNumbers < 0) {
            throw new RuntimeException("Balance of fruit can't be negative");
        }
        Storage.storageMap.put(fruit, newNumbers);
    }
}

