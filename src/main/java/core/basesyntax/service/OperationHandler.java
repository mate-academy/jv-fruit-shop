package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void processData(Fruit fruit, int quantity);
}
