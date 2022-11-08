package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;

public interface OperationStrategy {
    void processOperation(FruitTransaction fruitTransaction);
}
