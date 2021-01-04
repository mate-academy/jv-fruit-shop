package core.basesyntax.service.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation.Type operation) {
        return operationHandlerMap.get(operation);
    }
}
