package core.basesyntax.service;

import core.basesyntax.operations.OperationHandler;

public interface HandlerReceiver {
    OperationHandler getHandler(String operation);
}
