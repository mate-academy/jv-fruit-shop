package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void action(Fruit fruit, int quantity);
}
