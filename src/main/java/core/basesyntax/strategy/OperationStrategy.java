package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    FruitOperationHandler getHandler(Operation operation);
}
