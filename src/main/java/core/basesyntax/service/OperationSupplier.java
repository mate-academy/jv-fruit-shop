package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitOperationHandler;

public interface OperationSupplier {
    FruitOperationHandler getOperation(Fruit fruitOperation);
}
