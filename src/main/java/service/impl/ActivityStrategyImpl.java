package service.impl;

import java.util.Map;
import service.impl.activity.ActivityHandler;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> activityHandlersMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> activityHandlersMap) {
        this.activityHandlersMap = activityHandlersMap;
    }

    @Override
    public ActivityHandler select(String activityType) {
        return activityHandlersMap.get(activityType);
    }
}
