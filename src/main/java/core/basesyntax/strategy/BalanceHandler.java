package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.STORAGE.put(fruit, quantity);
    }
}
