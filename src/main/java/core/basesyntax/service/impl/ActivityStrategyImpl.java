package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.activity.strategy.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<Activity.Type, ActivityHandler> activitiesHandlerMap;

    public ActivityStrategyImpl(Map<Activity.Type, ActivityHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    public ActivityHandler get(Activity.Type type) {
        return activitiesHandlerMap.get(type);
    }
}
