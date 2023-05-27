package strategy;

import java.util.Map;
import model.OperationType;

//Implementation of the strategy based on the Map that is created in the main class.
public class DalyOperationStrategyImpl implements DalyOperationStrategy {
    private Map<OperationType, Integer> operationTypeMap;

    public DalyOperationStrategyImpl(Map<OperationType, Integer> operationTypeMap) {
        this.operationTypeMap = operationTypeMap;
    }

    @Override
    public Integer getOperation(String type) {
        return operationTypeMap.get(OperationType.valueOf(type.toUpperCase()));
    }
}
