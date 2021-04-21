package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.service.activityhandler.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Activity.Type, ActivityHandler> activitiesHandleMap;

    public ActivityStrategyImpl(Map<Activity.Type, ActivityHandler> activitiesHandleMap) {
        this.activitiesHandleMap = activitiesHandleMap;
    }

    @Override
    public ActivityHandler get(Activity.Type type) {
        return activitiesHandleMap.get(type);
    }
}
