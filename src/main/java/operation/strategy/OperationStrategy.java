package operation.strategy;

import operation.handler.OperationHandler;
import transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
