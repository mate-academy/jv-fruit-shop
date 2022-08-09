package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationType(FruitTransaction.Operation operation);
}
