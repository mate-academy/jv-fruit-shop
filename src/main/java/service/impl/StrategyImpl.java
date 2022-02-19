package service.impl;

import java.util.Map;
import service.OperationHandler;
import service.Strategy;

public class StrategyImpl implements Strategy {
    private final Map<String, OperationHandler> stringStoreActivitiesMap;

    public StrategyImpl(Map<String, OperationHandler> stringStoreActivitiesMap) {
        this.stringStoreActivitiesMap = stringStoreActivitiesMap;
    }

    @Override
    public OperationHandler getActivity(String storeActivityType) {
        if (!stringStoreActivitiesMap.containsKey(storeActivityType)) {
            throw new RuntimeException("No such activityType");
        }
        return stringStoreActivitiesMap.get(storeActivityType);
    }
}
