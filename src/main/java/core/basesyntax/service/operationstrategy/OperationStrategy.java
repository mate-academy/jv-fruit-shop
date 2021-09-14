package core.basesyntax.service.operationstrategy;

import core.basesyntax.service.operationhandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String operation);
}
