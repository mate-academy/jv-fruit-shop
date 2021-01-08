package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface Operation {
    void doOperation(Fruit fruit, int quantity);
}
