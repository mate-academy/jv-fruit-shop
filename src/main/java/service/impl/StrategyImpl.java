package service.impl;

import java.util.Map;
import service.StoreActivities;
import service.Strategy;

public class StrategyImpl implements Strategy {
    private final Map<String, StoreActivities> stringStoreActivitiesMap;

    public StrategyImpl(Map<String, StoreActivities> stringStoreActivitiesMap) {
        this.stringStoreActivitiesMap = stringStoreActivitiesMap;
    }

    @Override
    public StoreActivities getActivity(String storeActivityType) {
        if (!stringStoreActivitiesMap.containsKey(storeActivityType)) {
            throw new RuntimeException("No such activityType");
        }
        return stringStoreActivitiesMap.get(storeActivityType);
    }
}
