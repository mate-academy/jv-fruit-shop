package service.impl;

import java.util.Map;
import service.Activity;
import service.OperationStrategy;
import service.operation.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Activity, Operation> activityOperationMap;

    public OperationStrategyImpl(Map<Activity, Operation> activityOperationMap) {
        this.activityOperationMap = activityOperationMap;
    }

    @Override
    public Operation get(Activity activity) {
        return activityOperationMap.get(activity);
    }
}
