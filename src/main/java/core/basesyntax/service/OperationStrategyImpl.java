package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation.Type type) {
        return operationHandlerMap.get(type);
    }
}
