package homework.strategy;

import homework.service.impl.FruitTransaction.Operation;
import homework.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation type);
}
