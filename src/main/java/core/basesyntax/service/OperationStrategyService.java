package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategyService {
    void applyOperationStrategy(FruitTransaction fruitTransaction);
}
