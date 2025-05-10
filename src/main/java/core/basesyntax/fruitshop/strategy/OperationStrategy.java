package core.basesyntax.fruitshop.strategy;

import core.basesyntax.fruitshop.model.FruitTransaction.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
