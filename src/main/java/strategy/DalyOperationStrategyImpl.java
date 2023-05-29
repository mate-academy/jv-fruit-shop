package strategy;

import java.util.Map;
import model.OperationType;
import service.operation.handlers.OperationHandler;

//Implementation of the strategy based on the Map that is created in the main class.
public class DalyOperationStrategyImpl implements DalyOperationStrategy {
    private Map<OperationType, OperationHandler> operationTypeMap;

    public DalyOperationStrategyImpl(Map<OperationType, OperationHandler> operationTypeMap) {
        this.operationTypeMap = operationTypeMap;
    }

    @Override
    public OperationHandler getOperation(OperationType operationType) {
        return operationTypeMap.get(operationType);
    }
}
