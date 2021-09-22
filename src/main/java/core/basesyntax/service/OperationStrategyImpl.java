package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation.Type operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return operationHandlerMap.get(operation);
    }
}
