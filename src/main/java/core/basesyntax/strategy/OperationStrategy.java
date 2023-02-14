package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
