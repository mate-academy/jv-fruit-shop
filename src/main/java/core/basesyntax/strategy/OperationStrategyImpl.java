package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
