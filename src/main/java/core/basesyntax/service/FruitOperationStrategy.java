package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitsOperationHandler;

public interface FruitOperationStrategy {
    FruitsOperationHandler get(FruitTransaction.Operation operation);
}
