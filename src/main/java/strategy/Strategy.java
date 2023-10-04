package strategy;

import models.FruitTransaction;
import service.operation.OperationHandler;

public interface Strategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
