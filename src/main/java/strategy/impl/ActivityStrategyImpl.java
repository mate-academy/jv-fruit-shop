package strategy.impl;

import java.util.Map;
import model.ActivityType;
import strategy.ActivityHandler;
import strategy.ActivityStrategy;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<ActivityType, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<ActivityType, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler getHandler(ActivityType activity) {
        return activityHandlerMap.get(activity);
    }
}
