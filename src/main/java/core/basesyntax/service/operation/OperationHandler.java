package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int quantity);
}
