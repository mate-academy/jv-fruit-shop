package core.basesyntax.service.handlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public interface OperationHandler {
    void processOperation(Operation operation, Fruit fruit, Integer quantity);
}
