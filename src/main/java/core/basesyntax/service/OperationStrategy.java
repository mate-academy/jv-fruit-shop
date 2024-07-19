package core.basesyntax.service;

import core.basesyntax.domain.Fruit;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Fruit.Operation operation);
}
