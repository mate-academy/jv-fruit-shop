package homework.strategy;

import homework.model.FruitTransaction.Operation;
import homework.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation type);
}
