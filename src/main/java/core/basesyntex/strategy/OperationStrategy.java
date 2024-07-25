package core.basesyntex.strategy;

import core.basesyntex.model.Operation;
import core.basesyntex.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
