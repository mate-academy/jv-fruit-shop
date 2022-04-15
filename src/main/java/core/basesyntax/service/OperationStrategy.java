package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(String type);
}
