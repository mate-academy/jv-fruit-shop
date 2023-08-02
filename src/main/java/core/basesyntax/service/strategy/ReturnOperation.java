package core.basesyntax.service.strategy;

import core.basesyntax.storage.Storage;

public class ReturnOperation implements OperationStrategy {
    @Override
    public void apply(String fruit, Integer quantity) {
        Storage.fruits.merge(fruit, quantity, Integer::sum);
    }
}
