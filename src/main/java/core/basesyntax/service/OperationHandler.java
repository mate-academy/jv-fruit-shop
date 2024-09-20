package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int quantity);
}
