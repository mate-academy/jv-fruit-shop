package core.basesyntax.service.strategy;

import core.basesyntax.service.strategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operationType);
}
