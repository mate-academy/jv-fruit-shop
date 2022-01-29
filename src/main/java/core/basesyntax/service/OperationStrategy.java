package core.basesyntax.service;

import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String type);
}
