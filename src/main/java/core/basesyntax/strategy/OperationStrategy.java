package core.basesyntax.strategy;

import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType type);
}
