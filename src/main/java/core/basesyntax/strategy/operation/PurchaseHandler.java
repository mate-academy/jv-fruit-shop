package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(String fruit, int quantity) {
        int valueBeforeOperation = 0;
        if (Storage.storage.keySet().contains(fruit) && Storage.storage.get(fruit) - quantity > 0) {
            valueBeforeOperation = Storage.storage.get(fruit);
            Storage.storage.put(fruit, valueBeforeOperation - quantity);
        } else {
            throw new RuntimeException("Balance after purchase will be negative");
        }
    }
}
