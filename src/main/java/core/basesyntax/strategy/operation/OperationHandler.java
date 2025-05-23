package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitOperation;

public interface OperationHandler {
    int getQuantityFromStore(FruitOperation fruitOperation, int value);
}
