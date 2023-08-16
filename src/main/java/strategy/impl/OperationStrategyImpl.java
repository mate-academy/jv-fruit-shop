package strategy.impl;

import java.util.Map;
import strategy.Operation;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationsMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler get(Operation type) {
        return operationsMap.get(type);
    }
}
