package core.basesyntax.service;

import core.basesyntax.handler.DataOperationHandler;
import core.basesyntax.model.Fruit;

public interface OperationsStrategy {
    DataOperationHandler get(Fruit.Operation operation);
}
