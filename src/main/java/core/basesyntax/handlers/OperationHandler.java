package core.basesyntax.handlers;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void doOperation(Fruit fruit, Integer quantity);
}
