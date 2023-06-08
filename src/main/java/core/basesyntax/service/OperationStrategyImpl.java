package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler getOperationDirection(Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
