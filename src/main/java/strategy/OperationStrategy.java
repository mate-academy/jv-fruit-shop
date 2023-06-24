package strategy;

import model.FruitTransaction;
import strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
