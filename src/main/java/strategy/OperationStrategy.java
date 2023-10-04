package strategy;

import model.FruitTransaction;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationStrategy(FruitTransaction.OperationType type);
}
