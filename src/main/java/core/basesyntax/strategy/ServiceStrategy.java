package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;

public interface ServiceStrategy {
    OperationHandler getOperation(String operation);
}
