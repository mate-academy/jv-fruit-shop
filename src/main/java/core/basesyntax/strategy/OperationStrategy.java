package core.basesyntax.strategy;

import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.transactor.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
