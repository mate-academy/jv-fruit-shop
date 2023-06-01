package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlerStrategy {
    OperationHandler getByOperation(FruitTransaction.Operation operation);
}
