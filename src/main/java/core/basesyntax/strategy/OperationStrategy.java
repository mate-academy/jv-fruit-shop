package core.basesyntax.strategy;

import core.basesyntax.strategy.handler.Operation;
import core.basesyntax.strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
