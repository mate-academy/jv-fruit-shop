package core.basesyntax.operations;

import core.basesyntax.model.Fruit;

public interface Operation {
    void apply(Fruit fruit, Integer quantity);
}
