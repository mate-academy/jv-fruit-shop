package strategy;

import model.FruitTransaction;

public interface FruitStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}


