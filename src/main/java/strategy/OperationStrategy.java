package strategy;

import model.FruitTransaction;

public interface OperationStrategy {
    public OperationHandler getHandler(FruitTransaction.Operation operation);
}
