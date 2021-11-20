package core.basesyntax.service.interfaces;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
