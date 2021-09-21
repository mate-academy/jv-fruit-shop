package core.basesyntax.service.strategy;

import core.basesyntax.service.activity.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(String activity) {
        return activityHandlerMap.get(activity);
    }
}
