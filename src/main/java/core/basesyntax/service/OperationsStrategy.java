package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.DataOperationHandler;

public interface OperationsStrategy {
    DataOperationHandler get(Fruit.Operation operation);
}
