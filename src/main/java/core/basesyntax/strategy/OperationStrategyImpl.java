package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(String operation) {
        return operationHandlers.get(operation);
    }
}
