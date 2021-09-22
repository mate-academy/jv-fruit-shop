package core.basesyntax.operationstrategy;

import core.basesyntax.model.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType operationType);
}
