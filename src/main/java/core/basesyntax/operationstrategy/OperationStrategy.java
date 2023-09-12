package core.basesyntax.operationstrategy;

import core.basesyntax.operationstrategy.operation.OperationHandler;
import core.basesyntax.operationstrategy.operation.OperationType;

public interface OperationStrategy {
    OperationHandler get(OperationType type);
}
