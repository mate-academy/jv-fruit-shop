package core.basesyntax.service.handlers;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
