package core.basesyntax.service;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;

public interface ReceivingHandler {
    OperationHandler getHandler(Operation operation);
}
