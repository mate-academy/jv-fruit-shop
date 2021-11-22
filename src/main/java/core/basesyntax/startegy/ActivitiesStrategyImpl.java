package core.basesyntax.startegy;

import core.basesyntax.activities.ActivitiesHandler;
import core.basesyntax.activities.ActivityType;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<ActivityType, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl(Map<ActivityType, ActivitiesHandler> activitiesHandlerMap) {
        this.activitiesHandlerMap = activitiesHandlerMap;
    }

    @Override
    public ActivitiesHandler get(ActivityType type) {
        return activitiesHandlerMap.get(type);
    }
}
