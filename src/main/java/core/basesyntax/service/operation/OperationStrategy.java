package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.OperationType operationType);
}
