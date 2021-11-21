package core.basesyntax.strategy;

import java.util.Map;

public class ActivityStrategy {

    private Map<String, ActivityService> activityHandlerMap;

    public ActivityStrategy(Map<String, ActivityService> activityHandlerMap) {
        this.activityHandlerMap = activityHandlerMap;
    }

    public ActivityService getActivityService(String activity) {

        ActivityService activityService = activityHandlerMap.get(activity);
        if (activityService != null) {
            return activityService;
        }
        throw new RuntimeException("Undefined activity: " + activity);
    }
}

