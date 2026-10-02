package service.strategy;

import model.FruitTransaction;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
