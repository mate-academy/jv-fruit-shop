package service;

import model.FruitTransaction;
import service.operation.OperationsHandler;

public interface OperationOption {
    OperationsHandler getHandler(FruitTransaction fruitTransaction);
}
