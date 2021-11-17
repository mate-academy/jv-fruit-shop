package core.basesyntax.strategy;

import core.basesyntax.service.activitiy.ActivityHandler;
import core.basesyntax.service.activitiy.ActivityType;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<ActivityType, ActivityHandler> activityHandlerMap;

    public ActivitiesStrategyImpl(Map<ActivityType, ActivityHandler> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    @Override
    public ActivityHandler get(ActivityType activityType) {
        return activityHandlerMap.get(activityType);
    }
}
