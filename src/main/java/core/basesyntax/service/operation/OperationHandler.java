package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    int apply(int amount, Fruit key);
}
