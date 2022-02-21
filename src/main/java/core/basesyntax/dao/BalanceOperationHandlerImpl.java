package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }
}
