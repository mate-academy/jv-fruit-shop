package core.basesyntax.service;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;

public interface ReceiveHandler {
    OperationHandler getHandler(Operation operation);
}
