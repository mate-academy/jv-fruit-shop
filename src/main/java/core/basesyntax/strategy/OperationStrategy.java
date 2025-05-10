package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.FruitOperationHandler;

public interface OperationStrategy {
    FruitOperationHandler get(FruitTransaction.Operation type);
}
