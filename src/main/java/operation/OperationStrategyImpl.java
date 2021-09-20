package operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, Operation> operationMap;

    public OperationStrategyImpl(Map<OperationType, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation getOperation(OperationType type) {
        return operationMap.get(type);
    }
}
