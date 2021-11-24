package core.basesyntax.strategy;

import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
