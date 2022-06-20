package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitOperation;

public interface OperationSupplier {
    FruitOperation getOperation(Fruit fruit);
}
