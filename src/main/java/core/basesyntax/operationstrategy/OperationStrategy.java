package core.basesyntax.operationstrategy;

import core.basesyntax.operationstrategy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Character type);
}
