package core.basesyntax.operationstrategy;

import core.basesyntax.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType operationType);
}
