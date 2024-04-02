package strategy.strategies;

import model.FruitTransaction;
import service.Handler.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
