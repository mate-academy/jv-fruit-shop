package core.basesyntax.strategy;

import core.basesyntax.services.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
