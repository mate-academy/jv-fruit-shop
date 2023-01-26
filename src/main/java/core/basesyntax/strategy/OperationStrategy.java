package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(String operation, Map<String, OperationHandler> operationHandlerMap);
}
