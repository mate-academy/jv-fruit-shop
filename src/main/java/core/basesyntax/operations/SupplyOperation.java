package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void updateDB(String fruit, int quantity, Storage storage) {
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) + quantity);
    }
}
