package service;

import model.FruitTransaction;
import operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}

