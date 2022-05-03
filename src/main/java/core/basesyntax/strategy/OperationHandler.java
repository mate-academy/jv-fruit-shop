package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void process(Fruit fruit, Integer quantity);
}
