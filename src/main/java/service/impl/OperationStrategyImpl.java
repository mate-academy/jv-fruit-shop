package service.impl;

import java.util.Map;
import service.OperationStrategy;
import service.operation.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, Operation> activityOperationMap;

    public OperationStrategyImpl(Map<String, Operation> activityOperationMap) {
        this.activityOperationMap = activityOperationMap;
    }

    @Override
    public Operation get(String activity) {
        return activityOperationMap.get(activity);
    }
}
