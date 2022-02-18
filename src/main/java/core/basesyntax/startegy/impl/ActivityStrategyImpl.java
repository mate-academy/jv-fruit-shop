package core.basesyntax.startegy.impl;

import core.basesyntax.startegy.ActivityHandler;
import core.basesyntax.startegy.ActivityStrategy;
import core.basesyntax.startegy.ActivityType;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<ActivityType, ActivityHandler> activitiesHandlerMap;

    public ActivityStrategyImpl(Map<ActivityType, ActivityHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivityHandler get(ActivityType type) {
        return activitiesHandlerMap.get(type);
    }
}
