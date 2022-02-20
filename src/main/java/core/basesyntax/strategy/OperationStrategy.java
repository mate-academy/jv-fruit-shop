package core.basesyntax.strategy;

import core.basesyntax.services.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String operation);
}
