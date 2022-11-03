package strategy;

import models.FruitTransaction;
import service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
