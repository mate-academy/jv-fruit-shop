package service.impl;

import java.util.Map;
import model.OperationType;
import service.FruitStrategy;
import service.OperationHandler;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<OperationType, OperationHandler> activityHandleMap;

    public FruitStrategyImpl(Map<OperationType, OperationHandler> activityHandleMap) {
        this.activityHandleMap = activityHandleMap;
    }

    @Override
    public OperationHandler get(OperationType type) {
        return activityHandleMap.get(type);
    }
}
