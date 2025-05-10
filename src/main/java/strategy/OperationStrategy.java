package strategy;

import model.FruitTransaction;
import strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction fruitTransaction);
}
