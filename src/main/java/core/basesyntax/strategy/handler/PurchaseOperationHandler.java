package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doOperation(String fruit, int numbers) {
        int newNumbers = Storage.storage.get(fruit) - numbers;
        if (newNumbers < 0) {
            throw new RuntimeException("Balance of fruit can't be negative");
        }
        Storage.storage.put(fruit, newNumbers);
    }
}

