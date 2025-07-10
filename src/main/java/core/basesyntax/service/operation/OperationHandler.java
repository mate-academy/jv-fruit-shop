package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void doOperation(Fruit fruit, int quantity);
}
