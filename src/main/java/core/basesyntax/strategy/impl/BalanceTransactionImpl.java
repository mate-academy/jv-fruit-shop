package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceTransactionImpl implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Storage.getFruitStore().put(fruit, quantity);
    }
}
