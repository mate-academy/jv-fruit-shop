package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler getOperation(Operation operation,
                                  Map<Operation, OperationHandler> operationHandlerMap);
}
