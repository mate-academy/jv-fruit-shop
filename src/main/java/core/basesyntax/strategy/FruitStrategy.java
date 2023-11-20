package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface FruitStrategy {
    OperationHandler getOperationHandler(Operation operation);
}


