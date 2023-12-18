package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public interface OperationStrategy {
    OperationHandler get(Fruit.Operation operation);
}
