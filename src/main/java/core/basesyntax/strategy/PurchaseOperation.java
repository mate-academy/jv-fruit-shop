package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationStrategy {
    @Override
    public void apply(Fruit fruit, Integer quantity) {
        Storage.fruits.merge(fruit, quantity, (oldValue, subtrahend) -> oldValue - subtrahend);
    }
}
