package core.basesyntax.strategy;

import core.basesyntax.service.activitiy.ActivityHandler;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<String, ActivityHandler> activityHandlerMap;

    public ActivitiesStrategyImpl(Map<String, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(String activityTypeLetter) {
        return activityHandlerMap.get(activityTypeLetter);
    }
}
