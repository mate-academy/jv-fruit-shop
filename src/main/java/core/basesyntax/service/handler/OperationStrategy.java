package core.basesyntax.service.handler;

import core.basesyntax.model.enums.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
