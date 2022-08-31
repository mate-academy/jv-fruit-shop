package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void execute(Fruit fruit, Integer quantity);
}
