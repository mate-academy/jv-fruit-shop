package core.basesyntax.strategy;

import core.basesyntax.operation.Activity;
import core.basesyntax.service.activity.ActivityService;
import java.util.Map;

public class ServiceStrategyImpl implements ServiceStrategy {
    private Map<Activity, ActivityService> activityServiceMap;

    public ServiceStrategyImpl(Map<Activity, ActivityService> activityServiceMap) {
        this.activityServiceMap = activityServiceMap;
    }

    @Override
    public ActivityService get(Activity activity) {
        return activityServiceMap.get(activity);
    }
}
