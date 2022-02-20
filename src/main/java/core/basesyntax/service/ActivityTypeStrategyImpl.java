package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityHandler;
import java.util.Map;

public class ActivityTypeStrategyImpl implements ActivityTypeStrategy {
    private Map<ActivitiesType, ActivityHandler> activityTypesHandlerMap;

    public ActivityTypeStrategyImpl(Map<ActivitiesType, ActivityHandler>
                                            activityTypesHandlerMap) {
        this.activityTypesHandlerMap = activityTypesHandlerMap;
    }

    @Override
    public ActivityHandler get(ActivitiesType activitiesType) {
        return activityTypesHandlerMap.get(activitiesType);
    }
}
