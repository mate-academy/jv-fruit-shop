package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int quantity);
}
