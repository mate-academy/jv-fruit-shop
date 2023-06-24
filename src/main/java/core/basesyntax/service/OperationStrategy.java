package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation type);
}
