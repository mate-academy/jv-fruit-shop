package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;

public interface FruitOperationStrategy {
    FruitOperationHandler getHandler(FruitOperation fruitOperation);
}
