package core.fruitshop.strategy.interfaces;

import core.fruitshop.OperationType;

public interface OperationStrategy {
    OperationHandler getStrategy(OperationType type);
}
