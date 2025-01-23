package core.basesyntax.operations.operationstrategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
