package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.activity.Activity;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Fruit.Type, Activity> activityMap;

    public ActivityStrategyImpl(Map<Fruit.Type, Activity> activityMap) {
        this.activityMap = activityMap;
    }

    @Override
    public Activity get(Fruit.Type type) {
        return activityMap.get(type);
    }
}
