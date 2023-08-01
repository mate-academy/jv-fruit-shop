package core.basesyntax.operationstrategy;

import core.basesyntax.operationstrategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
