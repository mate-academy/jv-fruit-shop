package core.basesyntax.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler getOperation(OperationType type) {
        return operationMap.get(type);
    }
}
