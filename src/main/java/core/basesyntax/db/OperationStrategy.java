package core.basesyntax.db;

import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType type);
}
