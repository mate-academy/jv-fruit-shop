package strategy.impl;

import java.util.Map;
import model.OperationType;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<OperationType, OperationHandler> operationTypeMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationTypeMap) {
        this.operationTypeMap = operationTypeMap;
    }

    @Override
    public OperationHandler getOperation(OperationType operationType) {
        return operationTypeMap.get(operationType);
    }
}
