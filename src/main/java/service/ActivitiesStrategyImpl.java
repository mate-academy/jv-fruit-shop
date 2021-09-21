package service;

import java.util.Map;
import service.activities.Activities;
import service.activities.TypeOfActivities;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<TypeOfActivities, Activities> activitiesMap;

    public ActivitiesStrategyImpl(Map<TypeOfActivities, Activities> activitiesMap) {
        this.activitiesMap = activitiesMap;
    }

    @Override
    public Activities get(TypeOfActivities type) {
        return activitiesMap.get(type);
    }
}
