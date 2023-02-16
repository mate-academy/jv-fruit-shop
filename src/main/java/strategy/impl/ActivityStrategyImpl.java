package strategy.impl;

import java.util.Map;
import strategy.ActivityHandler;
import strategy.ActivityStrategy;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler getActivity(String activity) {
        return activityHandlerMap.get(activity);
    }
}
