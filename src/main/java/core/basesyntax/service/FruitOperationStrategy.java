package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public interface FruitOperationStrategy {
    OperationHandler put(FruitTransaction fruitTransaction);
}
