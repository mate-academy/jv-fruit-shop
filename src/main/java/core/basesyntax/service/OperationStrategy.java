package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operations.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
