package service.operation;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation operation);
}
