package operationStrategy;

import operationHandler.OperationHandler;
import transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
