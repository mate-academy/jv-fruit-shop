package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void performOperation(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
