package core.basesyntax.impl;

import core.basesyntax.strategy.ActivitiesHandler;
import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<String, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<String, ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(String activity) {
        return activitiesHandlerMap.get(activity);
    }
}
