package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.impl.OperationStrategy;

public interface HandleStrategy {
    OperationStrategy getStrategy(FruitTransaction.Operation operation);
}
