package core.basesyntax.operationHandling;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationHandling.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
