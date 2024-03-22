package core.basesyntax.strategy.impl;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
