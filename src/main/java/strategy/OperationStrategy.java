package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation type);

    int applyOperation(FruitTransaction transaction, int currentAmount);
}
