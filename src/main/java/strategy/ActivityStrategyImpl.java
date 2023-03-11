package strategy;

import java.util.Map;
import strategy.activity.ActivityHandler;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(String activityType) {
        return activityHandlerMap.get(activityType);
    }
}
