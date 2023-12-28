package core.basesyntax.service.strategy;

import core.basesyntax.constants.Activity;
import java.util.Map;

public class ActivityTypeStrategyImpl implements ActivityTypeStrategy {
    private final Map<String, Activity> activityMap;

    public ActivityTypeStrategyImpl(Map<String, Activity> activityMap) {
        this.activityMap = activityMap;
    }

    @Override
    public Activity get(String csvActivity) {
        Activity returnableActivity = activityMap.get(csvActivity);
        if (returnableActivity != null) {
            return returnableActivity;
        } else {
            throw new RuntimeException("Invalid operation " + csvActivity);
        }
    }
}
