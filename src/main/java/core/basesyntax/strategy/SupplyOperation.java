package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;

public class SupplyOperation implements OperationStrategy {
    @Override
    public void apply(String fruit, Integer quantity) {
        Storage.fruits.merge(fruit, quantity, Integer::sum);
    }
}
