package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
