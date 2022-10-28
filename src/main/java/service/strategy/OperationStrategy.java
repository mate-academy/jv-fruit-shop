package service.strategy;

import model.FruitTransaction;
import service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
