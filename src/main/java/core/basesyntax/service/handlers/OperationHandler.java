package core.basesyntax.service.handlers;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void handle(Fruit fruit, Integer quantity);
}
