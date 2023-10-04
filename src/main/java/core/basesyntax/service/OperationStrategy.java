package core.basesyntax.service;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.util.Operation;

public interface OperationStrategy {
    OperationHandler getOperationStrategy(Operation operation);
}
