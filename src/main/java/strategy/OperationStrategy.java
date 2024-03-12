package strategy;

import model.FruitTransaction;
import strategy.activities.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
