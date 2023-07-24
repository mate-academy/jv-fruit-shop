package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);

    OperationHandler get(String type);
}
