package core.basesyntax.stategy;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    FruitOperationHandler getHandler(Operation operation);
}
