package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void updateNumberOffFruit(String fruit, int amount) {
        Storage.storage.put(fruit, amount);
    }
}
