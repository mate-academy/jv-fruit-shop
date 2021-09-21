package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityTypeHandler;
import java.util.Map;

public class ActivityTypeStrategyImpl implements ActivityTypeStrategy {
    private Map<ActivitiesType, ActivityTypeHandler> activityTypesHandlerMap;

    public ActivityTypeStrategyImpl(Map<ActivitiesType, ActivityTypeHandler>
                                            activityTypesHandlerMap) {
        this.activityTypesHandlerMap = activityTypesHandlerMap;
    }

    @Override
    public ActivityTypeHandler get(ActivitiesType activitiesType) {
        return activityTypesHandlerMap.get(activitiesType);
    }
}
