package core.basesyntax.shop.implementation;

import core.basesyntax.handlers.Activity;
import core.basesyntax.shop.ActivitieStrategy;
import java.util.Map;

public class ActivitieStrategyImpl implements ActivitieStrategy {
    private Map<String, Activity> activitieMap;

    public ActivitieStrategyImpl() {
        activitieMap = new HandlerMap().getHandlerMap();
    }

    @Override
    public Activity get(String action) {
        return activitieMap.get(action.toUpperCase());
    }
}
