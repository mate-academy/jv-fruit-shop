package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperation(String key);
}
