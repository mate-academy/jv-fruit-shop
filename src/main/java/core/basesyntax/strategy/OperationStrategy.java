package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
