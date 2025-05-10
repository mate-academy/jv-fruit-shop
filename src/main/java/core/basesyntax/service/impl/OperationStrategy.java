package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Fruit.Operation type);
}
