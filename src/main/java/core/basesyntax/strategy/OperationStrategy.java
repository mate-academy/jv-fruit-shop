package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public interface OperationStrategy {
    OperationType operationHandler(FruitTransaction.Operation operation);
}
