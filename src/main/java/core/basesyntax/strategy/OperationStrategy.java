package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler operationHandler(Operation operation);
}
