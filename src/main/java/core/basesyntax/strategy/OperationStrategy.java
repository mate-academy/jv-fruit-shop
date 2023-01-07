package core.basesyntax.strategy;

import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
