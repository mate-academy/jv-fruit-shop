package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void getOperation(String name, int amount) {
        Storage.fruits.put(name, amount);
    }
}
