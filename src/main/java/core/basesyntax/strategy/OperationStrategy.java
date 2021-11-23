package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
