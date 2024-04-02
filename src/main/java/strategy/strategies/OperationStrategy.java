package strategy.strategies;

import model.FruitTransaction;
import service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
