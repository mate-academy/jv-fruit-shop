package strategy;

import model.FruitTransaction;
import strategy.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
