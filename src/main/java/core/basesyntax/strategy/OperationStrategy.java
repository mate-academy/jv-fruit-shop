package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationStrategy {
    Operation get(Fruit.Operation operation);
}
