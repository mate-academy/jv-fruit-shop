package service;

import model.FruitTransaction;
import service.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
