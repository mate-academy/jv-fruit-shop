package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;

public interface StoreOperationsStrategy {
    OperationHandler process(Operation operation);
}
