package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
