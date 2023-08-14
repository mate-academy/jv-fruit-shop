package core.strategy;

import core.model.FruitTransaction;
import core.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
