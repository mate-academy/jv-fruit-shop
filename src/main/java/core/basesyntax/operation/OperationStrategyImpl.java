package core.basesyntax.operation;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operations, Operation> operationMap;

    public OperationStrategyImpl(Map<Operations, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(Operations type) {
        return operationMap.get(type);
    }
}
