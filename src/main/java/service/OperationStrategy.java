package service;

import model.FruitTransaction;
import service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler update(FruitTransaction fruitTransaction);
}
