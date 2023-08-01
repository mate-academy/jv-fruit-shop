package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void updateDB(String fruit, int quantity, Storage storage) {
        if (storage.getStorage().get(fruit) - quantity < 0) {
            throw new RuntimeException("Quantity value can't be less than zero");
        }
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) - quantity);
    }
}
