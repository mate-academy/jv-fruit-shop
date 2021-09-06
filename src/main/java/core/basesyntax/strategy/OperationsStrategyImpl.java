package core.basesyntax.strategy;

import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<Operations, Operation> operationMap;

    public OperationsStrategyImpl(Map<Operations, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation get(Operations type) {
        return operationMap.get(type);
    }
}
