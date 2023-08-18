package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit, Integer quantity) {
        Storage.getStorage().put(fruit, quantity);
    }
}
