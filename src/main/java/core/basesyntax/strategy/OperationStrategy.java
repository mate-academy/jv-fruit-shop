package core.basesyntax.strategy;

import core.basesyntax.model.enums.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
