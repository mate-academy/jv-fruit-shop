package strategy.handler;

import model.FruitTransaction;

public interface OperationHandler {
    FruitTransaction getOperationResult(FruitTransaction fruitTransaction);
}
