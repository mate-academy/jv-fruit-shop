package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.ActivityTypeStrategy;
import core.basesyntax.strategy.ActivityTypeHandler;
import java.util.Map;

public class ActivityTypeStrategyImpl implements ActivityTypeStrategy {
    private Map<String, ActivityTypeHandler> activityTypeServiceMap;

    public ActivityTypeStrategyImpl(Map<String, ActivityTypeHandler> activityTypeServiceMap) {
        this.activityTypeServiceMap = activityTypeServiceMap;
    }

    @Override
    public ActivityTypeHandler get(String code) {
        return activityTypeServiceMap.get(code);
    }
}
