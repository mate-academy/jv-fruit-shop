package strategy.strategies;

import model.FruitTransaction;
import service.Handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
