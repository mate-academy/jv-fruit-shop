package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);

}
