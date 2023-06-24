package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandleStrategyImpl implements OperationHandlerStrategy {
    private final Map<Operation, OperationHandler> operationHandleMap;

    public OperationHandleStrategyImpl(Map<Operation, OperationHandler> operationHandleMap) {
        this.operationHandleMap = operationHandleMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandleMap.get(operation);
    }
}
