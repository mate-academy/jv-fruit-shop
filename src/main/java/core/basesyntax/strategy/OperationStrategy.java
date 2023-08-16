package core.basesyntax.strategy;

import core.basesyntax.strategy.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(String type);
}
