package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationsservice.FruitOperationHandler;

public interface OperationStrategy {
    FruitOperationHandler getOperation(FruitTransaction.Operation operation);
}
