package service;

import model.FruitTransaction;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction fruitTransaction);
}
