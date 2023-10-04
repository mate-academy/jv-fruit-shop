package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        if (getFruitQuantity(fruit) - quantity < 0) {
            throw new RuntimeException("Current fruit quantity is "
                    + getFruitQuantity(fruit));
        }
        Storage.storage.put(fruit, getFruitQuantity(fruit) - quantity);
    }

    private int getFruitQuantity(String fruit) {
        return Storage.storage.get(fruit);
    }
}
