package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationStrategy {
    void apply(Fruit fruit, Integer quantity);
}
