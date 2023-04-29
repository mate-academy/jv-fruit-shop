package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int operate(String fruit, int number) {
        if (Storage.storage.get(fruit) - number > 0) {
            return Storage.storage.get(fruit) - number;
        }
        throw new RuntimeException("Balance after purchase will be negative");
    }
}
