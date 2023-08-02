package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;

public class BalanceOperation implements OperationStrategy {
    @Override
    public void apply(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
