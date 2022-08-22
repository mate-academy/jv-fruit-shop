package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandleMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandleMap) {
        this.operationHandleMap = operationHandleMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandleMap.get(operation);
    }
}
