package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransactionImpl.Operation operation);
}
