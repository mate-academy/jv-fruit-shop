package core.basesyntax.service;

import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.OperationHandler;

public interface StrategyOperationService {
    OperationHandler get(OperationType operationType);
}
