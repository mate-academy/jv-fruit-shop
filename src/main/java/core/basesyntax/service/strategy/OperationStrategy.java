package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler operationHandler(FruitTransaction.Operation operationType);
}
