package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.activity.ActivityHandler;

import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Fruit.ACTIVITY, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<Fruit.ACTIVITY, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(Fruit.ACTIVITY activity) {
        return activityHandlerMap.get(activity);
    }
}
