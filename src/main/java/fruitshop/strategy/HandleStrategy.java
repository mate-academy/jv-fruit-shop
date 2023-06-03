package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.handler.OperationHandler;

public interface HandleStrategy {
    OperationHandler getStrategy(FruitTransaction.Operation operation);
}
