package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
