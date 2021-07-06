package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
