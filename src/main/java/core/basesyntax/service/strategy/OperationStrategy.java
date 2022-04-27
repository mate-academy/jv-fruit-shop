package core.basesyntax.service.strategy;

import core.basesyntax.service.strategy.handlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operationType);
}
