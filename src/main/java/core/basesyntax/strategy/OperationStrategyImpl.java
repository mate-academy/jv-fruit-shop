package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(String operation,
                                Map<String, OperationHandler> operationHandlerMap) {
        return operationHandlerMap.get(operation);
    }
}
