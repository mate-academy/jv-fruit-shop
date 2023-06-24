package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategyHandler {
    OperationHandler get(FruitTransaction.Operation type);
}
