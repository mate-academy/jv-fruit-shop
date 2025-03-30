package core.basesyntax.operationhandler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
