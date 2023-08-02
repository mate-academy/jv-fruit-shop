package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;

public interface StrategyService {
    OperationHandler getHandler(Operation operation);
}
