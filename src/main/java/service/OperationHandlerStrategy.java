package service;

import model.FruitTransaction;
import service.strategy.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
