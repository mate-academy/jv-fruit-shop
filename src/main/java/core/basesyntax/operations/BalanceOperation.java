package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void updateDB(String fruit, int quantity, Storage storage) {
        storage.getStorage().put(fruit, quantity);
    }
}
