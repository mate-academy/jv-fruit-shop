package core.basesyntax.service.operations;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    int apply(int amount, Fruit key);
}
