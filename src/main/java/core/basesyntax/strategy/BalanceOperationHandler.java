package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
