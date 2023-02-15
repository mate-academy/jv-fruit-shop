package strategy;

import model.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
