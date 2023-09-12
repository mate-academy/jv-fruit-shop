package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType type);
}
