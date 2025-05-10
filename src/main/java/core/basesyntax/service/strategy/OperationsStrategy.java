package core.basesyntax.service.strategy;

import core.basesyntax.model.Operations;

public interface OperationsStrategy {
    OperationHandler get(Operations operation);
}
