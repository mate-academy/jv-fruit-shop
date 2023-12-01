package core.basesyntax.serviceOperate;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandlerService getOperationHandler(Operation operation);
}
