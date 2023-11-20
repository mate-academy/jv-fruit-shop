package service;

import model.FruitTransaction;
import service.activities.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
