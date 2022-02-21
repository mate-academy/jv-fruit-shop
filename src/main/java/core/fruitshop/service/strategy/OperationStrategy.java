package core.fruitshop.service.strategy;

import core.fruitshop.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
