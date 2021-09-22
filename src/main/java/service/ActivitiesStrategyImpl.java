package service;

import java.util.Map;
import service.activities.ActivityHandler;
import service.activities.TypeOfActivities;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<TypeOfActivities, ActivityHandler> activitiesMap;

    public ActivitiesStrategyImpl(Map<TypeOfActivities, ActivityHandler> activitiesMap) {
        this.activitiesMap = activitiesMap;
    }

    @Override
    public ActivityHandler get(TypeOfActivities type) {
        return activitiesMap.get(type);
    }
}
