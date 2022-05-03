package servise.strategy;

import model.FruitTransaction;
import operation.OperationHandler;

public interface StrategyOperation {
    OperationHandler getOperation(FruitTransaction fruitTransaction);
}
