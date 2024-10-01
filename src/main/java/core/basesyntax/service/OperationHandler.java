package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void handle(Fruit fruit, int quantity);
}
