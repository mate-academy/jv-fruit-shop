package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void operate(String fruitType, int amount) {
        Storage.storage.put(fruitType, amount);
    }
}
