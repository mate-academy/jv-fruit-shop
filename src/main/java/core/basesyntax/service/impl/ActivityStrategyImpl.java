package core.basesyntax.service.impl;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.activity.strategy.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<FruitActivity.Type, ActivityHandler> activitiesHandlerMap;

    public ActivityStrategyImpl(Map<FruitActivity.Type, ActivityHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivityHandler get(FruitActivity.Type type) {
        return activitiesHandlerMap.get(type);
    }
}
