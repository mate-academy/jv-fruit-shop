package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceOperation implements OperationStrategy {
    @Override
    public void apply(Fruit fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
