package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.activity.ActivityHandler;

import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.ACTIVITY, ActivityHandler> activityHandlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.ACTIVITY, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(FruitTransaction.ACTIVITY activity) {
        return activityHandlerMap.get(activity);
    }
}
