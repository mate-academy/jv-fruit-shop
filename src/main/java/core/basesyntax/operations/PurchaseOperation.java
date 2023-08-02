package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity, Storage storage) {
        if (storage.getStorage().get(fruit) - quantity < 0) {
            throw new RuntimeException("Current fruit quantity is "
                    + storage.getStorage().get(fruit));
        }
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) - quantity);
    }
}
